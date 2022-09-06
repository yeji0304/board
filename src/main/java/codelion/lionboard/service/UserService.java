package codelion.lionboard.service;

import codelion.lionboard.dto.user.UserRequestDto;
import codelion.lionboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;


    @Transactional
    public Long save(UserRequestDto requestDto) {
        requestDto.setPassword(encoder.encode(requestDto.getPassword()));

        return userRepository.save(requestDto.toEntity()).getId();
    }

}

