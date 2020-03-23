package com.company.Test;

import com.company.DataBase.DataBaseStructure;
import org.junit.jupiter.api.Test;

public class DataBaseStructureTest {

    @Test public void createEnrolleeTableTest() throws Exception {
        DataBaseStructure.createEnrolleeTable();
    }

    @Test public void dropEnrrolleeTableTest() throws Exception {
        DataBaseStructure.dropEnrolleeTable();
    }

    @Test public void createSpecialityTableTest() throws Exception {
        DataBaseStructure.createSpecialityTable();
    }

    @Test public void dropSpecialityTableTest() throws Exception {
        DataBaseStructure.dropSpecialityTable();
    }
}
