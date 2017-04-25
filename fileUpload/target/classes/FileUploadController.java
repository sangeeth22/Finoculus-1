@Controller
public class FileUploadController {
	 @Autowired
	    private FileUploadDAO fileUploadDao;
	 
	    @RequestMapping(value = "/", method = RequestMethod.GET)
	    public String showUploadForm(HttpServletRequest request) {
	        return "Upload";
	    }
	     
	    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
	    public String handleFileUpload(HttpServletRequest request,
	            @RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
	          
	        if (fileUpload != null && fileUpload.length > 0) {
	            for (CommonsMultipartFile aFile : fileUpload){
	                  
	                System.out.println("Saving file: " + aFile.getOriginalFilename());
	                 
	                UploadFile uploadFile = new UploadFile();
	                uploadFile.setFileName(aFile.getOriginalFilename());
	                uploadFile.setData(aFile.getBytes());
	                fileUploadDao.save(uploadFile);               
	            }
	        }
	  
	        return "Success";
	    }  
}
