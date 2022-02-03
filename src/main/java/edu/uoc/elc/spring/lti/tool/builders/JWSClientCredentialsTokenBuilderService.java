package edu.uoc.elc.spring.lti.tool.builders;

import edu.uoc.elc.lti.tool.Key;
import edu.uoc.elc.lti.tool.Registration;
import edu.uoc.lti.clientcredentials.ClientCredentialsTokenBuilder;
import edu.uoc.lti.jwt.client.JWSClientCredentialsTokenBuilder;
import org.springframework.stereotype.Service;

/**
 * Universitat Oberta de Catalunya
 * Made for the project spring-boot-lti-advantage-jkws
 */
@Service
public class JWSClientCredentialsTokenBuilderService implements ClientCredentialsTokenBuilderService {
	@Override
	public ClientCredentialsTokenBuilder getClientCredentialsTokenBuilder(Registration registration, String kid) {
		final Key key = registration.getKeySet().getKey(kid);
		return new JWSClientCredentialsTokenBuilder(key.getPublicKey(), key.getPrivateKey(), key.getAlgorithm());
	}
}
