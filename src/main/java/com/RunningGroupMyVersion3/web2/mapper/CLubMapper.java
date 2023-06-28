package com.RunningGroupMyVersion3.web2.mapper;

import com.RunningGroupMyVersion3.web2.dto.ClubDto;
import com.RunningGroupMyVersion3.web2.dto.EventDto;
import com.RunningGroupMyVersion3.web2.models.Club;
import com.RunningGroupMyVersion3.web2.models.Event;

import java.util.stream.Collectors;

import static com.RunningGroupMyVersion3.web2.mapper.EventMapper.mapToEventDto;

public class CLubMapper {
    public static Club mapToClub(ClubDto clubDto) {
        Club club = Club.builder()
                .id(clubDto.getId())
                .title(clubDto.getTitle())
                .photoUrl(clubDto.getPhotoUrl())
                .content(clubDto.getContent())
                .createdBy(clubDto.getCreatedBy())
                .createdOn(clubDto.getCreatedOn())
                .updatedOn(clubDto.getUpdatedOn())
                .build();
        return club;
    }
    public static ClubDto mapToClubDto(Club club) {
        ClubDto clubDto = ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdBy(club.getCreatedBy())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .events(club.getEvents().stream().map((event)-> mapToEventDto(event)).collect(Collectors.toList()))
                .build();
        return clubDto;
    }




}
