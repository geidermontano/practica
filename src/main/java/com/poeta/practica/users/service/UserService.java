package com.poeta.practica.users.service;

import com.poeta.practica.users.dto.UserDto;
import com.poeta.practica.users.entity.UserEntity;
import com.poeta.practica.users.error.LocalNotFoundException;
import com.poeta.practica.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getAllUsers() throws LocalNotFoundException {
        List<UserEntity> userEntities = userRepository.findAll();
        if (userEntities.isEmpty()) {
            throw new LocalNotFoundException("No users found");
        }
        return userEntities.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public UserDto getUserById(Integer id) throws LocalNotFoundException {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isPresent()) {
            return convertToDto(user.get());
        }
        throw new LocalNotFoundException("User not found");
    }
    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = convertToEntity(userDto);
        UserEntity savedUserEntity = userRepository.save(userEntity);
        return convertToDto(savedUserEntity);
    }

    public UserDto updateUser(Integer id, UserDto userDto) {
        if (userRepository.existsById(id)) {
            UserEntity userEntity = convertToEntity(userDto);
            userEntity.setId(id); // Ensure the id is set for update
            UserEntity updatedUserEntity = userRepository.save(userEntity);
            return convertToDto(updatedUserEntity);
        }
        return null;
    }

    public void deleteUser(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }
// functions auxiliaries
    private UserDto convertToDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setName(userEntity.getName());
        userDto.setLastname(userEntity.getLastname());
        userDto.setEmail(userEntity.getEmail());
        userDto.setPassword(userEntity.getPassword());
        return userDto;
    }

    private UserEntity convertToEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDto.getName());
        userEntity.setLastname(userDto.getLastname());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPassword(userDto.getPassword());
        return userEntity;
    }
}
