package org.geonetwork.gaap.dao;

import org.junit.Test;
import org.geonetwork.gaap.domain.util.OperationFactory;
import org.geonetwork.gaap.domain.operation.Operation;

import java.util.List;

/**
 * Tests for OperationDao class
 *
 * @author Jose
 */
public class OperationDaoTest extends AbstractDaoTest {
    OperationDao operationDao;

    public void setOperationDao(OperationDao operationDao) {
        this.operationDao = operationDao;
    }

    @Test
    public void testCreateOperation() {
        // Create a test operation
        Operation operation = OperationFactory.create();
        operationDao.saveOperation(operation);

        // Check operation was saved correctly
        Operation result = operationDao.findOperationById(operation.getHibernateId());
        assertEquals(operation, result);

        // Check 1 operation in database
        List<Operation> operations = operationDao.loadAllOperations();
        assertEquals(1, operations.size());

        // Create another test operation
        Operation operation2 = OperationFactory.create();
        operation2.setName("operation2");
        operationDao.saveOperation(operation2);

        // Check operation was saved correctly
        Operation result2 = operationDao.findOperationById(operation2.getHibernateId());
        assertEquals(operation2, result2);

        // Check 2 operation in database
        operations = operationDao.loadAllOperations();
        assertEquals(2, operations.size());

        // Check saved operations are distinct
        assertNotSame(result, result2);
    }

    @Test
    public void testUpdateOperation() {
        Operation operation = OperationFactory.create();
        operationDao.saveOperation(operation);

        Operation result = operationDao.findOperationById(operation.getHibernateId());

        assertEquals(operation, result);

        List<Operation> operations = operationDao.loadAllOperations();
        assertEquals(1, operations.size());

        operation.setName("new_opname");

        operationDao.saveOperation(operation);
        operations = operationDao.loadAllOperations();
        assertEquals(1, operations.size());

    }

    @Test
    public void testDeleteOperation() {
        Operation operation = OperationFactory.create();
        operationDao.saveOperation(operation);

        Operation result = operationDao.findOperationById(operation.getHibernateId());

        assertEquals(operation, result);

        try {
            operationDao.deleteOperation(operation);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        List<Operation> operations = operationDao.loadAllOperations();
        assertEquals(0, operations.size());
    }

    @Test
    public void testGetOperations() {
        Operation operation = OperationFactory.create();
        operation.setName("operation1");
        operationDao.saveOperation(operation);

        List<Operation> operations = operationDao.loadAllOperations();
        assertEquals(1, operations.size());

        Operation operation2 = OperationFactory.create();
        operation2.setName("operation2");
        operationDao.saveOperation(operation2);

        operations = operationDao.loadAllOperations();
        assertEquals(2, operations.size());

        Operation result = operationDao.findOperationById(operation.getHibernateId());
        assertEquals(operation.getName(), result.getName());

        Operation result2 = operationDao.findOperationById(operation2.getHibernateId());
        assertEquals(operation2.getName(), result2.getName());

        assertFalse(result.getName().equals(result2.getName()));

        result = operationDao.findOperationByName("operation2");
        assertNotNull(result);
        assertEquals(operation2, result);
        
        result = operationDao.findOperationByName("xxxxxxxxx");
        assertNull(result);
    }
}