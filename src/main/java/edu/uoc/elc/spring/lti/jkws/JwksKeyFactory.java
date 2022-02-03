package edu.uoc.elc.spring.lti.jkws;

import edu.uoc.elc.lti.tool.Key;
import edu.uoc.lti.jwt.AlgorithmFactory;

import java.util.Base64;

/**
 * Universitat Oberta de Catalunya
 * Made for the project spring-boot-lti-advantage
 */
public class JwksKeyFactory {
	public JwksKey from(Key key) {
		AlgorithmFactory algorithmFactory = new AlgorithmFactory(key.getPublicKey(), key.getPrivateKey(), key.getAlgorithm());

		return JwksKey.builder()
						.kty(key.getAlgorithm())
						.alg("RS256")
						.use("sig")
						.e(Base64.getUrlEncoder().encodeToString(algorithmFactory.getPublicKey().getPublicExponent().toByteArray()))
						.n(Base64.getUrlEncoder().encodeToString(algorithmFactory.getPublicKey().getModulus().toByteArray()))
						.kid(key.getId())
						.build();
	}
}
