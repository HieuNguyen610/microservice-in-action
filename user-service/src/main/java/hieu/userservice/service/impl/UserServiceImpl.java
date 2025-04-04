package hieu.userservice.service.impl;

import hieu.userservice.dto.DepartmentDto;
import hieu.userservice.dto.ResponseDto;
import hieu.userservice.dto.UserDto;
import hieu.userservice.entity.User;
import hieu.userservice.repository.UserRepository;
import hieu.userservice.service.ApiClient;
import hieu.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
@Slf4j(topic = "user-service")
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;
    private final WebClient webClient;
    private final ApiClient apiClient;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseDto getUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("User id = " + userId + " not found"));
        UserDto userDto = userEntityToDto(user);

//        ResponseEntity<DepartmentDto> responseEntity = restTemplate
//                .getForEntity("http://localhost:8081/api/departments/" + user.getDepartmentId(),
//                        DepartmentDto.class);
//
//        DepartmentDto departmentDto = responseEntity.getBody();

//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8081/api/departments/" + user.getDepartmentId())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();

        DepartmentDto departmentDto = apiClient.getDepartmentById(Long.valueOf(user.getDepartmentId()));

        return ResponseDto.builder()
                .user(userDto)
                .department(departmentDto)
                .build();
    }

    private UserDto userEntityToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
