package com.RunningGroupMyVersion3.web2.service.impl;

import com.RunningGroupMyVersion3.web2.dto.ClubDto;
import com.RunningGroupMyVersion3.web2.models.Club;
import com.RunningGroupMyVersion3.web2.models.UserEntity;
import com.RunningGroupMyVersion3.web2.repository.ClubRepository;
import com.RunningGroupMyVersion3.web2.repository.UserRepository;
import com.RunningGroupMyVersion3.web2.security.SecurityUtil;
import com.RunningGroupMyVersion3.web2.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.RunningGroupMyVersion3.web2.mapper.CLubMapper.mapToClub;
import static com.RunningGroupMyVersion3.web2.mapper.CLubMapper.mapToClubDto;

@Service
public class ClubServiceImpl implements ClubService {
    private ClubRepository clubRepository;
    private UserRepository userRepository;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository, UserRepository userRepository) {
        this.clubRepository = clubRepository;
        this.userRepository = userRepository;
    }


    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map((club) -> mapToClubDto(club)).collect(Collectors.toList());
    }


    @Override
    public Club saveClub(ClubDto clubDto) {
        String username = SecurityUtil.getSessionUser();
        UserEntity user = userRepository.findByUsername(username);
        Club club = mapToClub(clubDto);
        club.setCreatedBy(user);
        return clubRepository.save(club);
    }

    @Override
    public ClubDto findClubById(Long clubId) {
        Club club = clubRepository.findById(clubId).get();
        return mapToClubDto(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        String username = SecurityUtil.getSessionUser();
        UserEntity user = userRepository.findByUsername(username);
        Club club = mapToClub(clubDto);
        club.setCreatedBy(user);
        clubRepository.save(club);

    }


    @Override
    public void delete(Long clubId) {
        clubRepository.deleteById(clubId);

    }

    @Override
    public List<ClubDto> searchClubs(String query) {
        List<Club> clubs = clubRepository.searchClubs(query);
        return clubs.stream().map(club -> mapToClubDto(club)).collect(Collectors.toList());
    }
}
