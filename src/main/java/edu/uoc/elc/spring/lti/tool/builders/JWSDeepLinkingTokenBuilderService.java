package edu.uoc.elc.spring.lti.tool.builders;

import edu.uoc.elc.lti.tool.Key;
import edu.uoc.elc.lti.tool.Registration;
import edu.uoc.lti.deeplink.DeepLinkingTokenBuilder;
import edu.uoc.lti.jwt.deeplink.JWSTokenBuilder;
import org.springframework.stereotype.Service;

/**
 * Universitat Oberta de Catalunya
 * Made for the project spring-boot-lti-advantage-jkws
 */
@Service
public class JWSDeepLinkingTokenBuilderService implements DeepLinkingTokenBuilderService {
	@Override
	public DeepLinkingTokenBuilder getDeepLinkingTokenBuilder(Registration registration, String kid) {
		final Key key = registration.getKeySet().getKey(kid);
		return new JWSTokenBuilder(key.getPublicKey(), key.getPrivateKey(), key.getAlgorithm());
	}
}
