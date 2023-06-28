package com.RunningGroupMyVersion3.web2.repository;

import com.RunningGroupMyVersion3.web2.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}
