package com.visitbratislavabe.services;

import com.visitbratislavabe.dbmodels.PlaceDto;

public interface IPlaceRepositoryService {
    Iterable<PlaceDto> saveAll(Iterable<PlaceDto> places);
}
