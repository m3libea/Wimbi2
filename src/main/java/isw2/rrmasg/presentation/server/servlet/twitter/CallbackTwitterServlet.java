package isw2.rrmasg.presentation.server.servlet.twitter;

import isw2.rrmasg.presentation.server.AuthenticationProvider;
import isw2.rrmasg.presentation.server.RedirectHelper;
import isw2.rrmasg.presentation.shared.dtos.UserDTO;
import isw2.rrmasg.services.ServiceFactory;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.RequestToken;

public class CallbackTwitterServlet extends HttpServlet {

	private static final long serialVersionUID = -7933753981669583150L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Twitter twitter = new TwitterFactory().getInstance();
			String key = AuthenticationProvider.TWITTER_API_KEY;
			String secret = AuthenticationProvider.TWITTER_SECRET_KEY;
			RequestToken token = (RequestToken) request.getSession()
					.getAttribute("requestToken");
			String verifier = request.getParameter("oauth_verifier");
			twitter.setOAuthConsumer(key, secret);
			twitter.getOAuthAccessToken(token, verifier);
			User user = twitter.verifyCredentials();
			String sid = UUID.randomUUID().toString();

			UserDTO u = ServiceFactory.getUserService()
					.createOrLoginNonNativeUser(AuthenticationProvider.TWITTER,
							user.getId() + "", user.getScreenName(), sid);

			request.getSession().setAttribute("session.user", u);
			request.getSession().setAttribute("sid", sid);

			if (u != null) {
				response.sendRedirect(RedirectHelper.getApplicationURL() + AuthenticationProvider.TWITTER_REDIRECT + "?sid=" + sid);
			}
		} catch (TwitterException e) {
			throw new ServletException(e);
		}
	}
}
