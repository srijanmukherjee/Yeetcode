package com.srijanmukherjee.yeetcode.repository;

import com.srijanmukherjee.yeetcode.entity.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
}
