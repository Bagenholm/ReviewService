package org.ia.reviews;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Storage extends JpaRepository<Review, Long> {

}