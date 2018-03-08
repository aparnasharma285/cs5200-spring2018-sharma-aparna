package assignment;

import java.util.Collection;

import assignment.dao.ConnectionDao;
import assignment.dao.DeveloperDao;
import assignment.dao.EnumerationDao;
import assignment.dao.PageDao;
import assignment.dao.RoleDao;
import assignment.dao.UserDao;
import assignment.dao.WebsiteDao;
import assignment.dao.WidgetDao;
import assignment.models.Developer;
import assignment.models.HeadingWidget;
import assignment.models.HtmlWidget;
import assignment.models.ImageWidget;
import assignment.models.Page;
import assignment.models.User;
import assignment.models.Website;
import assignment.models.YouTubeWidget;

public class Hw_jdbc_sharma_aparna {

	private static DeveloperDao devDao = DeveloperDao.getInstance();
	private static UserDao userDao = UserDao.getInstance();
	private static WebsiteDao websiteDao = WebsiteDao.getInstance();
	private static PageDao pageDao = PageDao.getInstance();
	private static WidgetDao widgetDao = WidgetDao.getInstance();
	private static RoleDao roleDao = RoleDao.getInstance();
	private static EnumerationDao enumDao = EnumerationDao.getInstance();

	public static void main(String args[]) {

		

		// 1. Create the following developers and users. Insert into the correct tables
		// depending on the type

		System.out.println("Inserting data into table Person Developer and User\n");

		Developer alice = new Developer("Alice", "Wonder", "alice", "alice", "alice@wonder.com", "4321rewq");
		Developer bob = new Developer("Bob", "Marley", "bob", "bob", "bob@marley.com", "5432trew");
		Developer charlie = new Developer("Charles", "Garcia", "charlie", "charlie", "chuch@garcia.com", "6543ytre");
		User dan = new User("Dan", "Martin", "dan", "dan", "chuch@garcia.com", false, "7654fda");
		User ed = new User("Ed", "Karaz", "ed", "ed", "ed@kar.com", false, "5678dfgh");

		devDao.createDeveloper(alice);
		devDao.createDeveloper(bob);
		devDao.createDeveloper(charlie);
		userDao.createUser(dan);
		userDao.createUser(ed);

		System.out.println("Inserting data into Website table\n");

		Website Facebook = new Website("Facebook", "an online social media and social networking service", 1234234);
		Website Twitter = new Website("Twitter", "an online news and social networking service", 4321543);
		Website Wikipedia = new Website("Wikipedia", "a free online encyclopedia", 3456654);
		Website CNN = new Website("CNN", "an American basic cable and satellite television news channel", 6543345);
		Website CNET = new Website("CNET",
				"an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics",
				5433455);
		Website Gizmodo = new Website("Gizmodo",
				"a design, technology, science and science fiction website that also writes articles on politics",
				4322345);

		websiteDao.createWebsiteForDeveloper(1, Facebook);
		websiteDao.createWebsiteForDeveloper(2, Twitter);
		websiteDao.createWebsiteForDeveloper(3, Wikipedia);
		websiteDao.createWebsiteForDeveloper(1, CNN);
		websiteDao.createWebsiteForDeveloper(2, CNET);
		websiteDao.createWebsiteForDeveloper(3, Gizmodo);

		System.out.println("Inserting data into Page table\n");

		Page Home = new Page("Home", "Landing page", 123434);
		Page About = new Page("About", "Website description", 234545);
		Page Contact = new Page("Contact", "Addresses, phones, and contact info", 345656);
		Page Preferences = new Page("Preferences", "Where users can configure their preferences", 456776);
		Page Profile = new Page("Profile", "Users can configure their personal information", 567878);

		pageDao.createPageForWebsite(5, Home);
		pageDao.createPageForWebsite(6, About);
		pageDao.createPageForWebsite(3, Contact);
		pageDao.createPageForWebsite(4, Preferences);
		pageDao.createPageForWebsite(5, Profile);

		System.out.println("Inserting data into Widget table\n");

		HeadingWidget head123 = new HeadingWidget("head123", "Welcome", 0, "heading");
		HtmlWidget post234 = new HtmlWidget("post234", "<p>Lorem</p>", 0, "html");
		HeadingWidget head345 = new HeadingWidget("head345", "Hi", 1, "heading");
		HtmlWidget intro456 = new HtmlWidget("intro456", "<h1>Hi</h1>", 2, "html");
		ImageWidget image345 = new ImageWidget("image345", 50, 100, "", 3, "image", "/img/567.png");
		YouTubeWidget video456 = new YouTubeWidget("video456", 400, 300, "", 0, "youtube",
				"https://youtu.be/h67VX51QXiQ");

		widgetDao.createWidgetForPage(1, head123);
		widgetDao.createWidgetForPage(2, post234);
		widgetDao.createWidgetForPage(3, head345);
		widgetDao.createWidgetForPage(3, intro456);
		widgetDao.createWidgetForPage(3, image345);
		widgetDao.createWidgetForPage(4, video456);

		System.out.println("Inserting data into Role table\n");

		enumDao.addRole("Owner");
		enumDao.addRole("Editor");
		enumDao.addRole("Admin");
		enumDao.addRole("Reviewer");
		enumDao.addRole("Writer");

		System.out.println("Inserting data into WebsiteRole table\n");

		roleDao.assignWebsiteRole(1, 1, 1);
		roleDao.assignWebsiteRole(2, 1, 2);
		roleDao.assignWebsiteRole(3, 1, 3);

		roleDao.assignWebsiteRole(2, 2, 1);
		roleDao.assignWebsiteRole(3, 2, 2);
		roleDao.assignWebsiteRole(1, 2, 3);

		roleDao.assignWebsiteRole(3, 3, 1);
		roleDao.assignWebsiteRole(1, 3, 2);
		roleDao.assignWebsiteRole(2, 3, 3);

		roleDao.assignWebsiteRole(1, 4, 1);
		roleDao.assignWebsiteRole(2, 4, 2);
		roleDao.assignWebsiteRole(3, 4, 3);

		roleDao.assignWebsiteRole(2, 5, 1);
		roleDao.assignWebsiteRole(3, 5, 2);
		roleDao.assignWebsiteRole(1, 5, 3);

		roleDao.assignWebsiteRole(3, 6, 1);
		roleDao.assignWebsiteRole(1, 6, 2);
		roleDao.assignWebsiteRole(2, 6, 3);

		System.out.println("Inserting data into PageRole table\n");

		roleDao.assignPageRole(1, 1, 2);
		roleDao.assignPageRole(2, 1, 4);
		roleDao.assignPageRole(3, 1, 5);

		roleDao.assignPageRole(2, 2, 2);
		roleDao.assignPageRole(3, 2, 4);
		roleDao.assignPageRole(1, 2, 5);

		roleDao.assignPageRole(3, 3, 2);
		roleDao.assignPageRole(1, 3, 4);
		roleDao.assignPageRole(2, 3, 5);

		roleDao.assignPageRole(1, 4, 2);
		roleDao.assignPageRole(2, 4, 4);
		roleDao.assignPageRole(3, 4, 5);

		roleDao.assignPageRole(2, 5, 2);
		roleDao.assignPageRole(3, 5, 4);
		roleDao.assignPageRole(1, 5, 5);

		// Implement Updates

		implementUpdates();
		
		// Implement Delete
		implementDelete();
		
		System.out.println("Finished");

		
	}

	public static void implementUpdates() {

		// 1. Update developer - Update Charlie's primary phone number to 333-444-5555
		// updateQuestion1();

		// 2. Update widget - Update the relative order of widget head345 on the page so
		// that it's new order is 3.
		// updateQuestion2();

		// 3. Update page - Append 'CNET - ' to the beginning of all CNET's page titles
		updateQuestion3();

		// 4. Update roles - Swap Charlie's and Bob's role in CNET's Home page
		updateQuestion4();

	}

	public static void updateQuestion3() {

		// extract the WebsiteId of CNET
		int CNETId = websiteDao.findWebsiteId("CNET");

		// Find all Pages of CNET
		Collection<Page> pages = pageDao.findPagesForWebsite(CNETId);

		// Update title of each page one by one
		for (Page p : pages) {

			Page newPage = new Page(p.getId(), "CNET - " + p.getTitle(), p.getDescription(), p.getCreated(),
					p.getUpdated(), p.getViews());
			pageDao.updatePage(p.getId(), newPage);
		}
	}

	public static void updateQuestion1() {

	}

	public static void updateQuestion2() {

	}

	public static void updateQuestion4() {
		
		// find the pageId
		int CNETId = websiteDao.findWebsiteId("CNET");
		int pageId = pageDao.findPageId("CNET - Home", CNETId);

		// find developer id
		int bobDevId = (devDao.findDeveloperByUsername("bob")).getId();
		int charlieDevId = (devDao.findDeveloperByUsername("charlie")).getId();
		
		int result = roleDao.swapDevelopersPageRole(bobDevId,charlieDevId,pageId);

	}
	
	
	public static void implementDelete() {
		
		deleteQuestion1();
		deleteQuestion2();
		deleteQuestion3();
		deleteQuestion4();
		
	}
	
	public static void deleteQuestion4() {
		
		int websiteId = websiteDao.findWebsiteId("CNET");
		websiteDao.deleteWebsite(websiteId);
	}
	
	public static void deleteQuestion3() {
		
		pageDao.deletePage(pageDao.lastUpdated("Wikipedia"));
	}
	
	public static void deleteQuestion2() {
		
		widgetDao.deleteWidget(widgetDao.HighestOrderWidget("Contact"));
	}
	
	public static void deleteQuestion1() {
		
		devDao.deletePrimaryAddress((devDao.findDeveloperByUsername("alice")).getId());
	}
}
