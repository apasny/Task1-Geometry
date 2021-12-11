package com.epam.repository;

import com.epam.data.IdGenerator;
import com.epam.entities.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ConeRepositoryImplTest {

    @Test
    public void testSortShouldSortAccordingComparator() {
        //given
        ConeRepositoryImpl coneRepository = new ConeRepositoryImpl();
        IdGenerator idGenerator = new IdGenerator();
        double radius = 1;
        ConeIdentifiable coneIdentifiable1 = new ConeIdentifiable(idGenerator.generate(), new Cone(new BaseCenter(7, 3, 4), radius, new Apex(5, 6, 7)));
        ConeIdentifiable coneIdentifiable2 = new ConeIdentifiable(idGenerator.generate(), new Cone(new BaseCenter(1, 6, 7), radius, new Apex(8, 9, 10)));
        ConeIdentifiable coneIdentifiable3 = new ConeIdentifiable(idGenerator.generate(), new Cone(new BaseCenter(4, 6, 7), radius, new Apex(8, 9, 10)));
        coneRepository.add(coneIdentifiable1);
        coneRepository.add(coneIdentifiable2);
        coneRepository.add(coneIdentifiable3);

        //when
        List<ConeIdentifiable> result = coneRepository.sort(new SortByCoordinateX());

        //then
        Assert.assertEquals(coneIdentifiable1, result.get(2));
        Assert.assertEquals(coneIdentifiable2, result.get(0));
        Assert.assertEquals(coneIdentifiable3, result.get(1));
    }

    @Test
    public void testQueryShouldWorkAccordingAreaSpecification() {
        //given
        ConeRepositoryImpl coneRepository = new ConeRepositoryImpl();
        IdGenerator idGenerator = new IdGenerator();
        double radius = 1;
        ConeIdentifiable coneIdentifiable1 = new ConeIdentifiable(idGenerator.generate(), new Cone(new BaseCenter(2, 3, 4), radius, new Apex(5, 6, 7)));
        ConeIdentifiable coneIdentifiable2 = new ConeIdentifiable(idGenerator.generate(), new Cone(new BaseCenter(1, 6, 7), radius, new Apex(8, 9, 10)));
        ConeIdentifiable coneIdentifiable3 = new ConeIdentifiable(idGenerator.generate(), new Cone(new BaseCenter(4, 6, 7), radius, new Apex(8, 9, 10)));
        coneRepository.add(coneIdentifiable1);
        coneRepository.add(coneIdentifiable2);
        coneRepository.add(coneIdentifiable3);

        //when
        List<ConeIdentifiable> result = coneRepository.query(new AreaSpecification(19, 22));

        //then
        Assert.assertEquals(2, result.size());
    }

    @Test
    public void testQueryShouldWorkAccordingCoordinateLocationSpecification() {
        //given
        ConeRepositoryImpl coneRepository = new ConeRepositoryImpl();
        IdGenerator idGenerator = new IdGenerator();
        double radius = 1;
        ConeIdentifiable coneIdentifiable1 = new ConeIdentifiable(idGenerator.generate(), new Cone(new BaseCenter(-2, 3, 4), radius, new Apex(5, 6, 7)));
        ConeIdentifiable coneIdentifiable2 = new ConeIdentifiable(idGenerator.generate(), new Cone(new BaseCenter(1, 6, -7), radius, new Apex(8, 9, 10)));
        ConeIdentifiable coneIdentifiable3 = new ConeIdentifiable(idGenerator.generate(), new Cone(new BaseCenter(4, 6, 7), radius, new Apex(8, -9, 10)));
        coneRepository.add(coneIdentifiable1);
        coneRepository.add(coneIdentifiable2);
        coneRepository.add(coneIdentifiable3);

        //when
        List<ConeIdentifiable> result = coneRepository.query(new CoordinateLocationSpecification(Octant.FIRST));

        //then
        Assert.assertEquals(0, result.size());
    }

}
