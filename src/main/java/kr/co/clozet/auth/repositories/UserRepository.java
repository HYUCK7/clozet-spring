package kr.co.clozet.auth.repositories;

import kr.co.clozet.auth.domains.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
}
