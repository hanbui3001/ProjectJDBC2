package com.javaweb.repository;

import com.javaweb.repository.entity.rentAreaEntity;

public interface rentAreaRepository {
	rentAreaEntity findValue(Long from, Long to);
}
