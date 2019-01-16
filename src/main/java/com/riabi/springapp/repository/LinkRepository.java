package com.riabi.springapp.repository;

import com.riabi.springapp.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository <Link, Long> {
    /* JpaRepository extends :
    * PagingAndSortingRepository
    * QueryByExampleExecutor
    * CrudRepository*/

}
