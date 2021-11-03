package com.polimi.thesis.fsiciliano.poliapp.repository;

import com.polimi.thesis.fsiciliano.poliapp.model.Occupancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface OccupancyRepository extends JpaRepository<Occupancy, Long> {


    @Query(
            value = "SELECT * FROM SYSTEM.occupancy o WHERE " +
                    "o.DATE_START BETWEEN TO_TIMESTAMP(:dateStart, 'YYYY-MM-DD HH:MI:SS.FF') AND TO_TIMESTAMP(:dateEnd, 'YYYY-MM-DD HH:MI:SS.FF') OR " +
                    "o.DATE_END BETWEEN TO_TIMESTAMP(:dateStart, 'YYYY-MM-DD HH:MI:SS.FF') AND TO_TIMESTAMP(:dateEnd, 'YYYY-MM-DD HH:MI:SS.FF') OR " +
                    "o.DATE_START < TO_TIMESTAMP(:dateStart, 'YYYY-MM-DD HH:MI:SS.FF') AND o.DATE_END > TO_TIMESTAMP(:dateEnd, 'YYYY-MM-DD HH:MI:SS.FF') ",
            nativeQuery = true
    )
    List<Occupancy> getOccupanciesInDateRangeOf(
            @Param("dateStart") String start,
            @Param("dateEnd") String end);
}