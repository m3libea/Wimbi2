package isw2.rrmasg.services;

import java.util.regex.Pattern;

public class CheckEmailService {

	private static final Pattern VALID_PATTERN = Pattern
			.compile("^([0-9a-zA-Z]([-\\.\\w]*[0-9a-zA-Z])*@(([0-9a-zA-Z])([-\\w]*[0-9a-zA-Z])*\\.)[a-zA-Z]{2,9})$");

	public static boolean isEmail(String token) {
		return VALID_PATTERN.matcher(token).matches();
	}
}
