package isw2.rrmasg.presentation.server.servlet.twitter;

import isw2.rrmasg.presentation.server.AuthenticationProvider;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;

public class SingInTwitterServlet extends HttpServlet {

	private static final long serialVersionUID = -7933753981669583150L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Twitter twitter = new TwitterFactory().getInstance();
			String key = AuthenticationProvider.TWITTER_API_KEY;
			String secret = AuthenticationProvider.TWITTER_SECRET_KEY;
			StringBuffer callbackURL = request.getRequestURL();
			int index = callbackURL.lastIndexOf("/");
			callbackURL.replace(index, callbackURL.length(), "").append("/twitterLogin");
			twitter.setOAuthConsumer(key, secret);
			RequestToken token = twitter.getOAuthRequestToken(callbackURL.toString());
			request.getSession().setAttribute("requestToken", token);
			String loginURL = token.getAuthenticationURL();
			response.sendRedirect(loginURL);

		} catch (TwitterException e) {
			throw new ServletException(e);
		}
	}

}
