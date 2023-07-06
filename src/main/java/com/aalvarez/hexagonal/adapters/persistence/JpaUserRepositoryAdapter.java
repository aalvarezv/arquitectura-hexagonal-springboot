package com.aalvarez.hexagonal.adapters.persistence;

import com.aalvarez.hexagonal.adapters.exceptions.NotFoundException;
import com.aalvarez.hexagonal.adapters.exceptions.TemplateException;
import com.aalvarez.hexagonal.adapters.persistence.repositories.JpaUserRepository;
import com.aalvarez.hexagonal.application.ports.out.SaveUserPort;
import com.aalvarez.hexagonal.domain.model.User;
import com.aalvarez.hexagonal.application.ports.out.GetUserPort;
import com.aalvarez.hexagonal.adapters.persistence.entities.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaUserRepositoryAdapter implements GetUserPort, SaveUserPort {

    @Autowired
    private JpaUserRepository jpaUserRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public User findById(Long id) {

       UserEntity optUser = this.jpaUserRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("333", "Usuario id "+id+" no existe", "Comentario adicional"));

       return modelMapper.map(optUser, User.class);

    }

    @Override
    public List<User> findAll() {
        return jpaUserRepository.findAll()
                .stream().map(user -> modelMapper.map(user, User.class))
                .collect(Collectors.toList());
    }

    @Override
    public User save(User user) {

       Optional<UserEntity> userCheck =  jpaUserRepository.findById(user.getId());
       if(userCheck.isPresent()){
          throw new TemplateException("222", "Ya existe un usuario con id "+userCheck.get().getId(), "", HttpStatus.CONFLICT);
       }

       UserEntity userSave = modelMapper.map(user, UserEntity.class);

       return modelMapper.map(jpaUserRepository.save(userSave), User.class);

    }
}
