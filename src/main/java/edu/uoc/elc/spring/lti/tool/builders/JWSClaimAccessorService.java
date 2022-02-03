package edu.uoc.elc.spring.lti.tool.builders;

import edu.uoc.elc.lti.tool.Registration;
import edu.uoc.lti.claims.ClaimAccessor;
import edu.uoc.lti.jwt.claims.JWSClaimAccessor;
import org.springframework.stereotype.Service;

/**
 * Universitat Oberta de Catalunya
 * Made for the project spring-boot-lti-advantage-jkws
 */
@Service
public class JWSClaimAccessorService implements ClaimAccessorService {

	@Override
	public ClaimAccessor getClaimAccessor(Registration registration) {
		return new JWSClaimAccessor(registration.getKeySetUrl());
	}
}
