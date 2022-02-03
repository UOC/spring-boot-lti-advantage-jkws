package edu.uoc.elc.spring.lti.jkws;

import edu.uoc.elc.lti.tool.Key;
import edu.uoc.elc.spring.lti.tool.registration.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Universitat Oberta de Catalunya
 * Made for the project spring-boot-lti-advantage
 */
@RestController
@RequiredArgsConstructor
public class WellKnowKeysController {
	private final RegistrationService registrationService;

	@GetMapping("${jkws.wellkownuri:/.well-known/jwks.json}")
	public List<JwksKey> getKeys() {
		final List<Key> keys = registrationService.getAllKeys();
		final JwksKeyFactory keyFactory = new JwksKeyFactory();
		return keys.stream().map(keyFactory::from).collect(Collectors.toList());
	}
}
