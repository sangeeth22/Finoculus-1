@Repository
public class FileUploadDAOImpl implements FileUploadDAO{
	 @Autowired
	    private SessionFactory sessionFactory;
	     
	    public FileUploadDAOImpl() {
	    }
	 
	    public FileUploadDAOImpl(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
	 
	    @Override
	    @Transactional
	    public void save(UploadFile uploadFile) {
	        sessionFactory.getCurrentSession().save(uploadFile);
	    }
}
