package io.github.seondongpyo.security.domain;

import javax.annotation.PostConstruct;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User '" + username + "' not found"));
	}

	@PostConstruct
	public void addUsers() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		userRepository.save(User.builder()
			.username("user1")
			.password(passwordEncoder.encode("user1"))
			.role(Role.USER)
			.build());

		userRepository.save(User.builder()
			.username("user2")
			.password(passwordEncoder.encode("user2"))
			.role(Role.ADMIN)
			.build());
	}
}
