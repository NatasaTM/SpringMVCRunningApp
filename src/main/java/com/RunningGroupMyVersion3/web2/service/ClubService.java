package com.RunningGroupMyVersion3.web2.service;

import com.RunningGroupMyVersion3.web2.dto.ClubDto;
import com.RunningGroupMyVersion3.web2.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();
    Club saveClub(ClubDto clubDto);
    ClubDto findClubById(Long clubId);
    void updateClub(ClubDto club);
    void delete(Long clubId);
    List<ClubDto> searchClubs(String query);
}
