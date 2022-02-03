package edu.uoc.elc.spring.lti.jkws;

import lombok.Builder;
import lombok.Data;

/**
 * Represents a JWKS key. We're creating this class because com.auth0.jwk.Jwk, the class we work with,
 * doesn't have a method for transforming to JSON.
 * Universitat Oberta de Catalunya
 * Made for the project spring-boot-lti-advantage
 */
@Data
@Builder
public class JwksKey {
	private final String kty;
	private final String alg;
	private final String use;
	private final String e;
	private final String n;
	private final String kid;
}
