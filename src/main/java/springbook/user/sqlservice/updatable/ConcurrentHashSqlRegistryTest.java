package springbook.user.sqlservice.updatable;

import springbook.issuetracker.sqlservice.UpdatableSqlRegistry;

public class ConcurrentHashSqlRegistryTest extends AbstractUpdatableSqlRegistryTest{
	protected UpdatableSqlRegistry createUpdatableSqlRegistry() {
		return new ConcurrentHashMapSqlRegistry();
	}
}
