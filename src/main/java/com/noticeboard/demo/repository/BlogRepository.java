package com.noticeboard.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.noticeboard.demo.entity.Blog;

public interface BlogRepository extends CrudRepository<Blog, Long> {

    @Query(nativeQuery = true,
			value = "DELETE " +
					"  FROM blog " +
					" WHERE message_id in (:messageIdList) ")
	@Modifying(clearAutomatically = true)
	@Transactional
	int deleteAllByMessageIdList(@Param("messageIdList") List<Long> messageIdList);

	@Modifying
    @Transactional
    @Query(value =  "INSERT INTO blog (user_id, title, announce_content, announce_date, expiry_date) " + 
            "VALUES (?,?,?,?,?) "
            ,nativeQuery = true)
    void insertWithQuery(
        @Param("user_id") String string,
        @Param("title") String title,
        @Param("announce_content") String announceCntent,
        @Param("announce_date") LocalDate announceDate,
        @Param("expiry_date") LocalDate expiryDate
    );
    
}
