package com.Reboot.Minty.review.repository;

import com.Reboot.Minty.member.entity.User;
import com.Reboot.Minty.review.entity.Review;
import jakarta.persistence.OrderBy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
        List<Review> findByWriterIdIdOrderByCreatedAtDesc(Long userId);
        List<Review> findByBuyerIdOrSellerIdOrderByCreatedAtDesc(Long buyerId, Long sellerId);
        List<Review> findByWriterIdNotOrderByCreatedAtDesc(User writerId);
}
