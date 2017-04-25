
public class ApplicationContextConfig {
	@Autowired
	@Bean(name = "fileUploadDao")
	public FileUploadDAO getUserDao(SessionFactory sessionFactory) {
	    return new FileUploadDAOImpl(sessionFactory);
	}
	@Bean(name = "FileUploadModel")
	public FileUploadDAO getUserDao(SessionFactory sessionFactory) {
	    return new FileUploadDAOImpl(sessionFactory);
	}
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getCommonsMultipartResolver() {
	    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	    multipartResolver.setMaxUploadSize(20971520);   // 20MB
	    multipartResolver.setMaxInMemorySize(1048576);  // 1MB
	    return multipartResolver;
	}
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("org.h2.Driver");
	    dataSource.setUrl("jdbc:h2:~/test");
	    dataSource.setUsername("sa");
	    dataSource.setPassword("");
	 
	    return dataSource;
	}
}
