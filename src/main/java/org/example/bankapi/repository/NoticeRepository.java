package org.example.bankapi.repository;

import org.example.bankapi.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {

    @Query( "SELECT n " +
            "FROM Notice n " +
            "WHERE CURDATE() BETWEEN n.startDate AND n.endDate ")
    List<Notice> findAllActiveNotices();
}
