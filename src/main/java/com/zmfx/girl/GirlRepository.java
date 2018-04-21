package com.zmfx.girl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl,Integer> {

    /**
     * 通过年龄来查询
     * 方法名不能随便定义，按照约束才会按年龄查询
     */
     List<Girl> findByAge(Integer age);
}
