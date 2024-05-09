import java.util.*;
import java.io.*;
public class taskOne
{
	public static void main(String[] args)
	{
		menu();

	}
	public static void menu()
	{
	
		Scanner sc = new Scanner(System.in);
		Permit area = new Permit();
		Permit.Area areaa = area.new Area();
		System.out.println("Welcome to the Los Angeles (90063) Building Permit Program. There are currently a total of " + area.countAll("DataFile.csv") + " permits currently lodged." );
		System.out.println("");
		System.out.println("Please make a selection");
		System.out.println("");
		System.out.println("1. > All permits.\n" + "2. > Lodged at METRO.\n" + "3. > Lodged on INTERNET.\n" + "4. > Lodged at VAN NUYS.\n" + "5. > Lodged at SOUTH LA.\n" + "6. > Lodged at WEST LA.\n" + "7. > Lodged at SAN PEDRO.\n" + "8. > Enter a TRACT.\n" + "9. > Enter a CENSUS TRACT.\n" + "10. > Enter a COUNCIL DISTRICT.\n" + "11. > Exit");
		System.out.print("Enter: ");
		int choice = sc.nextInt();
		System.out.println("");
		while (choice != 11)
		{
			if (choice < 1 || choice > 11)
			{
				System.out.print("Enter a choice between 1 and 11: ");
				choice = sc.nextInt();
			}
			else if (choice == 11) // exit code
			{
				System.exit(0);
			}
			else if (choice == 1) // all permits
			{
				selectStat();
				int select = sc.nextInt();
				int a = select;
				float total = area.countAll("DataFile.csv");	
				
				if (a < 1 || a > 9)
				{
					System.out.println("Invalid input, try again.");
					
					
				}
				else if (a == 9) // exit from statistic menu for all permits
				{
					System.exit(0);
				}
				else if (a == 1) // stat of all permits
				{
					System.out.println("Total number of permits are: " + area.countAll("DataFile.csv"));
					System.out.println("");	
				}
				else if (a == 2) // stat of all permits with status permit finaled
				{
					System.out.println("Permits with status 'Permit Finaled': " + area.countAllWithStatus("DataFile.csv", "Permit Finaled"));
					float amt = area.countAllWithStatus("DataFile.csv", "Permit Finaled");
					percCalc(total, amt);
					System.out.println("");
				}
				else if (a == 3) // stat of all permits with status issued
				{
					System.out.println("Permits with status 'Issued': " + area.countAllWithStatus("DataFile.csv", "Issued"));
					float amt = area.countAllWithStatus("DataFile.csv", "Issued");
					percCalc(total, amt);
					System.out.println("");

				}
				else if (a == 4)
				{

					float eq1 = area.countAll("DataFile.csv"); 
					float eq2 = area.countAllWithStatus("DataFile.csv", "Issued") + area.countAllWithStatus("DataFile.csv", "Permit Finaled");
					float amt = eq1 - eq2;
					System.out.println("Permits with other status: " + amt);
					percCalc(total, amt);
					System.out.println("");

				}
				else if (a == 5)
				{
					System.out.println("Permits with type 'Electrical': " + area.typeOfPermit("DataFile.csv", "Electrical"));
					float amt = area.typeOfPermit("DataFile.csv", "Electrical");
					percCalc(total, amt);
					System.out.println("");
				}
				else if (a == 6)
				{
					System.out.println("Permits with type 'Plumbing': " + area.typeOfPermit("DataFile.csv", "Plumbing"));
					float amt = area.typeOfPermit("DataFile.csv", "Plumbing");
					percCalc(total, amt);
					System.out.println("");
				}
				else if (a == 7)
				{
					System.out.println("Permits with type 'HVAC': " + area.typeOfPermit("DataFile.csv", "HVAC"));
					float amt = area.typeOfPermit("DataFile.csv", "HVAC");
					percCalc(total, amt);
					System.out.println("");
				}
				else if (a == 8)
				{
					float ans = area.typeOfPermit("DataFile.csv", "Electrical") + area.typeOfPermit("DataFile.csv", "Plumbing") + area.typeOfPermit("DataFile.csv", "HVAC");
					float totalPermitsWithOtherType = area.countAll("DataFile.csv") - ans;
					System.out.println("Permits with other type status: " + totalPermitsWithOtherType);
					percCalc(total, totalPermitsWithOtherType);
					System.out.println("");
				}	
			}
			else if (choice == 2) // lodged on METRO
			{
				selectStat();
				int select = sc.nextInt();
				int a = select;
				float total = area.countOfPermits("DataFile.csv", "METRO");
				if (a < 1 || a > 9) 
				{
					System.out.println("Invalid input, try again");
					

				}
				else if (a == 9) // exit from stat menu for metro
				{
					System.exit(0);
				}
				else if (a == 1) // total number of permits at metro
				{
					System.out.println("Permits lodged at 'METRO': " + area.countOfPermits("DataFile.csv", "METRO"));
					System.out.println("");	
				}
				else if (a == 2) 
				{
					System.out.println("Permits lodged at 'METRO' with status 'Permit Finaled': " + area.countWithOfficeAndStatus("DataFile.csv", "METRO", "Permit Finaled"));
					float amt = area.countWithOfficeAndStatus("DataFile.csv", "METRO", "Permit Finaled");
					percCalc(total, amt);
					System.out.println("");
				}
				else if (a == 3)
				{
					System.out.println("Permits lodged at 'METRO' with status 'Issued': " + area.countWithOfficeAndStatus("DataFile.csv", "METRO", "Issued"));
					float amt = area.countWithOfficeAndStatus("DataFile.csv", "METRO", "Issued");
					percCalc(total, amt);
					System.out.println("");
				}
				else if (a == 4)
				{
					float ans = area.countWithOfficeAndStatus("DataFile.csv", "METRO", "Permit Finaled") + area.countWithOfficeAndStatus("DataFile.csv", "METRO", "Issued");
					float permitsAtMetroWithOtherStatus = area.countOfPermits("DataFile.csv", "METRO") - ans;
					System.out.println("Permits lodged at 'METRO' with other status: " + permitsAtMetroWithOtherStatus);
					percCalc(total, permitsAtMetroWithOtherStatus);
					System.out.println("");
				}
				else if (a == 5)
				{
					System.out.println("Permits lodged at 'METRO' with permit type 'Electrical': " + area.countWithOfficeAndType("DataFile.csv", "METRO", "Electrical"));
					float amt = area.countWithOfficeAndType("DataFile.csv", "METRO", "Electrical");
					percCalc(total, amt);
					System.out.println("");
				}
				else if (a == 6)
				{
					System.out.println("Permits lodged at 'METRO' with permit type 'Plumbing': " + area.countWithOfficeAndType("DataFile.csv", "METRO", "Plumbing"));
					float amt = area.countWithOfficeAndType("DataFile.csv", "METRO", "Plumbing");
					percCalc(total, amt);
					System.out.println("");
				}
				else if (a == 7)
				{
					System.out.println("Permits lodged at 'METRO' with permit type 'HVAC': " + area.countWithOfficeAndType("DataFile.csv", "METRO", "HVAC"));
					float amt = area.countWithOfficeAndType("DataFile.csv", "METRO", "HVAC");
					percCalc(total, amt);
					System.out.println("");
				}
				else if (a == 8)
				{
					float eq1 = area.countWithOfficeAndType("DataFile.csv", "METRO", "Electrical") + area.countWithOfficeAndType("DataFile.csv", "METRO", "Plumbing") + area.countWithOfficeAndType("DataFile.csv", "METRO", "HVAC");
					float permitsAtMetroWithOtherType = area.countOfPermits("DataFile.csv", "METRO") - eq1;
					System.out.println("Permits lodged at 'METRO' with other permit types: " + permitsAtMetroWithOtherType);
					percCalc(total, permitsAtMetroWithOtherType);
					System.out.println("");
				}

							
			}
			else if (choice == 3)
                        {
                                selectStat();
                                int select = sc.nextInt();
                                int a = select;
				float total = area.countOfPermits("DataFile.csv", "INTERNET");
                                if (a < 1 || a > 9)
                                {
                                        System.out.println("Invalid input, try again");


                                }
                                else if (a == 9)
                                {
                                        System.exit(0);
                                }
                                else if (a == 1) 
                                {
                                        System.out.println("Permits lodged on 'INTERNET': " + area.countOfPermits("DataFile.csv", "INTERNET"));
                                        System.out.println("");
                                }
                                else if (a == 2)
                                {
                                        System.out.println("Permits lodged on 'INTERNET' with status 'Permit Finaled': " + area.countWithOfficeAndStatus("DataFile.csv", "INTERNET", "Permit Finaled"));
					float amt = area.countWithOfficeAndStatus("DataFile.csv", "INTERNET", "Permit Finaled");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 3)
                                {
                                        System.out.println("Permits lodged on 'INTERNET' with status 'Issued': " + area.countWithOfficeAndStatus("DataFile.csv", "INTERNET", "Issued"));
					float amt = area.countWithOfficeAndStatus("DataFile.csv", "INTERNET", "Issued");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 4)
                                {
                                        float ans = area.countWithOfficeAndStatus("DataFile.csv", "INTERNET", "Permit Finaled") + area.countWithOfficeAndStatus("DataFile.csv", "INTERNET", "Issued");
                                        float permitsOnInternetWithOtherStatus = area.countOfPermits("DataFile.csv", "INTERNET") - ans;
                                        System.out.println("Permits lodged on 'INTERNET' with other status: " + permitsOnInternetWithOtherStatus);
					percCalc(total, permitsOnInternetWithOtherStatus);
					System.out.println("");
                                }
                                else if (a == 5)
                                {
                                        System.out.println("Permits lodged on 'INTERNET' with permit type 'Electrical': " + area.countWithOfficeAndType("DataFile.csv", "INTERNET", "Electrical"));
					float amt = area.countWithOfficeAndType("DataFile.csv", "INTERNET", "Electrical");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 6)
                                {
                                        System.out.println("Permits lodged on 'INTERNET' with permit type 'Plumbing': " + area.countWithOfficeAndType("DataFile.csv", "INTERNET", "Plumbing"));
					float amt = area.countWithOfficeAndType("DataFile.csv", "INTERNET", "Plumbing");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 7)
                                {
                                        System.out.println("Permits lodged on 'INTERNET' with permit type 'HVAC': " + area.countWithOfficeAndType("DataFile.csv", "INTERNET", "HVAC"));
					float amt = area.countWithOfficeAndType("DataFile.csv", "INTERNET", "HVAC");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 8)
                                {
                                        float eq1 = area.countWithOfficeAndType("DataFile.csv", "INTERNET", "Electrical") + area.countWithOfficeAndType("DataFile.csv", "INTERNET", "Plumbing") + area.countWithOfficeAndType("DataFile.csv", "INTERNET", "HVAC");
                                        float permitsOnInternetWithOtherType = area.countOfPermits("DataFile.csv", "INTERNET") - eq1;
                                        System.out.println("Permits lodged on 'INTERNET' with other permit types: " + permitsOnInternetWithOtherType);
					percCalc(total, permitsOnInternetWithOtherType);
                                        System.out.println("");
                                }


                        }
			else if (choice == 4)
                        {
                                selectStat();
                                int select = sc.nextInt();
                                int a = select;
				float total = area.countOfPermits("DataFile.csv", "VAN NUYS");
                                if (a < 1 || a > 9)
                                {
                                        System.out.println("Invalid input, try again");


                                }
                                else if (a == 9)
                                {
                                        System.exit(0);
                                }
                                else if (a == 1)
                                {
                                        System.out.println("Permits lodged at 'VAN NUYS': " + area.countOfPermits("DataFile.csv", "VAN NUYS"));
                                        System.out.println("");
                                }
                                else if (a == 2)
                                {
                                        System.out.println("Permits lodged at 'VAN NUYS' with status 'Permit Finaled': " + area.countWithOfficeAndStatus("DataFile.csv", "VAN NUYS", "Permit Finaled"));
					float amt = area.countWithOfficeAndStatus("DataFile.csv", "VAN NUYS", "Permit Finaled");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 3)
                                {
                                        System.out.println("Permits lodged at 'VAN NUYS' with status 'Issued': " + area.countWithOfficeAndStatus("DataFile.csv", "VAN NUYS", "Issued"));
					float amt = area.countWithOfficeAndStatus("DataFile.csv", "VAN NUYS", "Issued");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 4)
                                {
                                        float ans = area.countWithOfficeAndStatus("DataFile.csv", "VAN NUYS", "Permit Finaled") + area.countWithOfficeAndStatus("DataFile.csv", "VAN NUYS", "Issued");
                                        float permitsAtNuysWithOtherStatus = area.countOfPermits("DataFile.csv", "VAN NUYS") - ans;
                                        System.out.println("Permits lodged at 'VAN NUYS' with other status: " + permitsAtNuysWithOtherStatus);
					percCalc(total, permitsAtNuysWithOtherStatus);
					System.out.println("");
                                }
                                else if (a == 5)
                                {
                                        System.out.println("Permits lodged at 'VAN NUYS' with permit type 'Electrical': " + area.countWithOfficeAndType("DataFile.csv", "VAN NUYS", "Electrical"));
					float amt = area.countWithOfficeAndType("DataFile.csv", "VAN NUYS", "Electrical");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 6)
                                {
                                        System.out.println("Permits lodged at 'VAN NUYS' with permit type 'Plumbing': " + area.countWithOfficeAndType("DataFile.csv", "VAN NUYS", "Plumbing"));
					float amt = area.countWithOfficeAndType("DataFile.csv", "VAN NUYS", "Plumbing");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 7)
                                {
                                        System.out.println("Permits lodged at 'VAN NUYS' with permit type 'HVAC': " + area.countWithOfficeAndType("DataFile.csv", "VAN NUYS", "HVAC"));
					float amt = area.countWithOfficeAndType("DataFile.csv", "VAN NUYS", "HVAC");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 8)
                                {
                                        float eq1 = area.countWithOfficeAndType("DataFile.csv", "VAN NUYS", "Electrical") + area.countWithOfficeAndType("DataFile.csv", "VAN NUYS", "Plumbing") + area.countWithOfficeAndType("DataFile.csv", "VAN NUYS", "HVAC");
                                        float permitsAtNuysWithOtherType = area.countOfPermits("DataFile.csv", "VAN NUYS") - eq1;
                                        System.out.println("Permits lodged at 'VAN NUYS' with other permit types: " + permitsAtNuysWithOtherType);
					percCalc(total, permitsAtNuysWithOtherType);
                                        System.out.println("");
                                }


                        }
			else if (choice == 5)
                        {
                                selectStat();
                                int select = sc.nextInt();
                                int a = select;
				float total = area.countOfPermits("DataFile.csv", "SOUTH LA");
                                if (a < 1 || a > 9)
                                {
                                        System.out.println("Invalid input, try again");


                                }
                                else if (a == 9)
                                {
                                        System.exit(0);
                                }
                                else if (a == 1)
                                {
                                        System.out.println("Permits lodged at 'SOUTH LA': " + area.countOfPermits("DataFile.csv", "SOUTH LA"));
                                        System.out.println("");
                                }
                                else if (a == 2)
                                {
                                        System.out.println("Permits lodged at 'SOUTH LA' with status 'Permit Finaled': " + area.countWithOfficeAndStatus("DataFile.csv", "SOUTH LA", "Permit Finaled"));
					float amt = area.countWithOfficeAndStatus("DataFile.csv", "SOUTH LA", "Permit Finaled");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 3)
                                {
                                        System.out.println("Permits lodged at 'SOUTH LA' with status 'Issued': " + area.countWithOfficeAndStatus("DataFile.csv", "SOUTH LA", "Issued"));
					float amt = area.countWithOfficeAndStatus("DataFile.csv", "SOUTH LA", "Issued");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 4)
                                {
                                        float ans = area.countWithOfficeAndStatus("DataFile.csv", "SOUTH LA", "Permit Finaled") + area.countWithOfficeAndStatus("DataFile.csv", "SOUTH LA", "Issued");
                                        float permitsAtSouthWithOtherStatus = area.countOfPermits("DataFile.csv", "SOUTH LA") - ans;
                                        System.out.println("Permits lodged at 'SOUTH LA' with other status: " + permitsAtSouthWithOtherStatus);
					percCalc(total, permitsAtSouthWithOtherStatus);
					System.out.println("");
                                }
                                else if (a == 5)
                                {
                                        System.out.println("Permits lodged at 'SOUTH LA' with permit type 'Electrical': " + area.countWithOfficeAndType("DataFile.csv", "SOUTH LA", "Electrical"));
					float amt = area.countWithOfficeAndType("DataFile.csv", "SOUTH LA", "Electrical");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 6)
                                {
                                        System.out.println("Permits lodged at 'SOUTH LA' with permit type 'Plumbing': " + area.countWithOfficeAndType("DataFile.csv", "SOUTH LA", "Plumbing"));
					float amt = area.countWithOfficeAndType("DataFile.csv", "SOUTH LA", "Plumbing");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 7)
                                {
                                        System.out.println("Permits lodged at 'SOUTH LA' with permit type 'HVAC': " + area.countWithOfficeAndType("DataFile.csv", "SOUTH LA", "HVAC"));
					float amt = area.countWithOfficeAndType("DataFile.csv", "SOUTH LA", "HVAC");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 8)
                                {
                                        float eq1 = area.countWithOfficeAndType("DataFile.csv", "SOUTH LA", "Electrical") + area.countWithOfficeAndType("DataFile.csv", "SOUTH LA", "Plumbing") + area.countWithOfficeAndType("DataFile.csv", "SOUTH LA", "HVAC");
                                        float permitsAtSouthWithOtherType = area.countOfPermits("DataFile.csv", "SOUTH LA") - eq1;
                                        System.out.println("Permits lodged at 'VAN NUYS' with other permit types: " + permitsAtSouthWithOtherType);
					percCalc(total, permitsAtSouthWithOtherType);
                                        System.out.println("");
                                }


                        }
			else if (choice == 6)
                        {
                                selectStat();
                                int select = sc.nextInt();
                                int a = select;
				float total = area.countOfPermits("DataFile.csv", "WEST LA");
                                if (a < 1 || a > 9)
                                {
                                        System.out.println("Invalid input, try again");


                                }
                                else if (a == 9)
                                {
                                        System.exit(0);
                                }
                                else if (a == 1)
                                {
                                        System.out.println("Permits lodged at 'WEST LA': " + area.countOfPermits("DataFile.csv", "WEST LA"));
                                        System.out.println("");
                                }
                                else if (a == 2)
                                {
                                        System.out.println("Permits lodged at 'WEST LA' with status 'Permit Finaled': " + area.countWithOfficeAndStatus("DataFile.csv", "WEST LA", "Permit Finaled"));
					float amt = area.countWithOfficeAndStatus("DataFile.csv", "WEST LA", "Permit Finaled");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 3)
                                {
                                        System.out.println("Permits lodged at 'WEST LA' with status 'Issued': " + area.countWithOfficeAndStatus("DataFile.csv", "WEST LA", "Issued"));
					float amt = area.countWithOfficeAndStatus("DataFile.csv", "WEST LA", "Issued");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 4)
                                {
                                        float ans = area.countWithOfficeAndStatus("DataFile.csv", "WEST LA", "Permit Finaled") + area.countWithOfficeAndStatus("DataFile.csv", "WEST", "Issued");
                                        float permitsAtWestWithOtherStatus = area.countOfPermits("DataFile.csv", "WEST LA") - ans;
                                        System.out.println("Permits lodged at 'WEST LA' with other status: " + permitsAtWestWithOtherStatus);
					percCalc(total, permitsAtWestWithOtherStatus);
                                }
                                else if (a == 5)
                                {
                                        System.out.println("Permits lodged at 'WEST LA' with permit type 'Electrical': " + area.countWithOfficeAndType("DataFile.csv", "WEST LA", "Electrical"));
					float amt = area.countWithOfficeAndType("DataFile.csv", "WEST LA", "Electrical");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 6)
                                {
                                        System.out.println("Permits lodged at 'WEST LA' with permit type 'Plumbing': " + area.countWithOfficeAndType("DataFile.csv", "WEST LA", "Plumbing"));
					float amt = area.countWithOfficeAndType("DataFile.csv", "WEST LA", "Plumbing");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 7)
                                {
                                        System.out.println("Permits lodged at 'WEST LA' with permit type 'HVAC': " + area.countWithOfficeAndType("DataFile.csv", "WEST LA", "HVAC"));
					float amt = area.countWithOfficeAndType("DataFile.csv", "WEST LA", "HVAC");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 8)
                                {
                                        float eq1 = area.countWithOfficeAndType("DataFile.csv", "WEST LA", "Electrical") + area.countWithOfficeAndType("DataFile.csv", "WEST LA", "Plumbing") + area.countWithOfficeAndType("DataFile.csv", "WEST LA", "HVAC");
                                        float permitsAtWestWithOtherType = area.countOfPermits("DataFile.csv", "WEST LA") - eq1;
                                        System.out.println("Permits lodged at 'WEST LA' with other permit types: " + permitsAtWestWithOtherType);
					percCalc(total, permitsAtWestWithOtherType);
                                        System.out.println("");
                                }


                        }
			else if (choice == 7)
                        {
                                selectStat();
                                int select = sc.nextInt();
                                int a = select;
				float total = area.countOfPermits("DataFile.csv", "SANPEDRO");
                                if (a < 1 || a > 9)
                                {
                                        System.out.println("Invalid input, try again");


                                }
                                else if (a == 9)
                                {
                                        System.exit(0);
                                }
                                else if (a == 1)
                                {
                                        System.out.println("Permits lodged at 'SANPEDRO': " + area.countOfPermits("DataFile.csv", "SANPEDRO"));
                                        System.out.println("");
                                }
                                else if (a == 2)
                                {
                                        System.out.println("Permits lodged at 'SANPEDRO' with status 'Permit Finaled': " + area.countWithOfficeAndStatus("DataFile.csv", "SANPEDRO", "Permit Finaled"));
					float amt = area.countWithOfficeAndStatus("DataFile.csv", "SANPEDRO", "Permit Finaled");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 3)
                                {
                                        System.out.println("Permits lodged at 'SANPEDRO' with status 'Issued': " + area.countWithOfficeAndStatus("DataFile.csv", "SANPEDRO", "Issued"));
					float amt = area.countWithOfficeAndStatus("DataFile.csv", "SANPEDRO", "Issued");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 4)
                                {
                                        float ans = area.countWithOfficeAndStatus("DataFile.csv", "SANPEDRO", "Permit Finaled") + area.countWithOfficeAndStatus("DataFile.csv", "SANPEDRO", "Issued");
                                        float permitsAtSanWithOtherStatus = area.countOfPermits("DataFile.csv", "SANPEDRO") - ans;
                                        System.out.println("Permits lodged at 'SANPEDRO' with other status: " + permitsAtSanWithOtherStatus);
					percCalc(total, permitsAtSanWithOtherStatus);
					System.out.println("");
                                }
                                else if (a == 5)
                                {
                                        System.out.println("Permits lodged at 'SANPEDRO' with permit type 'Electrical': " + area.countWithOfficeAndType("DataFile.csv", "SANPEDRO", "Electrical"));
					float amt = area.countWithOfficeAndType("DataFile.csv", "SANPEDRO", "Electrical");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 6)
                                {
                                        System.out.println("Permits lodged at 'SANPEDRO' with permit type 'Plumbing': " + area.countWithOfficeAndType("DataFile.csv", "SANPEDRO", "Plumbing"));
					float amt = area.countWithOfficeAndType("DataFile.csv", "SANPEDRO", "Plumbing");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 7)
                                {
                                        System.out.println("Permits lodged at 'SANPEDRO' with permit type 'HVAC': " + area.countWithOfficeAndType("DataFile.csv", "SANPEDRO", "HVAC"));
					float amt = area.countWithOfficeAndType("DataFile.csv", "SANPEDRO", "HVAC");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 8)
                                {
                                        float eq1 = area.countWithOfficeAndType("DataFile.csv", "SANPEDRO", "Electrical") + area.countWithOfficeAndType("DataFile.csv", "SANPEDRO", "Plumbing") + area.countWithOfficeAndType("DataFile.csv", "SANPEDRO", "HVAC");
                                        float permitsAtSanWithOtherType = area.countOfPermits("DataFile.csv", "SANPEDRO") - eq1;
                                        System.out.println("Permits lodged at 'SANPEDRO' with other permit types: " + permitsAtSanWithOtherType);
					percCalc(total, permitsAtSanWithOtherType);
                                        System.out.println("");
                                }


                        }
			else if (choice == 8)
                        {
				String tractName = enterTract();
                                selectStat();
                                int select = sc.nextInt();
                                int a = select;
				float total = area.countAllWithTract("DataFile.csv", tractName);
                                if (a < 1 || a > 9)
				{
                                        System.out.println("Invalid input, try again");


                                }
                                else if (a == 9)
                                {
                                        System.exit(0);
                                }
                                else if (a == 1)
                                {
                                        System.out.println("Permits lodged at '" + tractName + "': "  + area.countAllWithTract("DataFile.csv", tractName));
                                        System.out.println("");
                                }
                                else if (a == 2)
                                {
                                        System.out.println("Permits lodged at '" + tractName + "' with status 'Permit Finaled': " + area.countTractWithOfficeAndStatus("DataFile.csv", tractName, "Permit Finaled"));
					float amt = area.countTractWithOfficeAndStatus("DataFile.csv", tractName, "Permit Finaled");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 3)
                                {
                                        System.out.println("Permits lodged at '" + tractName + "' with status 'Issued': " + area.countTractWithOfficeAndStatus("DataFile.csv", tractName, "Issued"));
					float amt = area.countTractWithOfficeAndStatus("DataFile.csv", tractName, "Issued");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 4)
                                {
                                        float eq1 = area.countTractWithOfficeAndStatus("DataFile.csv", tractName, "Permit Finaled") + area.countTractWithOfficeAndStatus("DataFile.csv", tractName, "Issued");
                                        float eq2 = area.countAllWithTract("DataFile.csv", tractName) - eq1;
                                        System.out.println("Permits lodged at '" + tractName + "' with other status: " + eq2);
					percCalc(total, eq2);
					System.out.println("");
                                }
                                else if (a == 5)
                                {
                                        System.out.println("Permits lodged at '" + tractName + "' with permit type 'Electrical': " + area.countTractWithOfficeAndType("DataFile.csv", tractName, "Electrical"));
					float amt = area.countTractWithOfficeAndType("DataFile.csv", tractName, "Electrical");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 6)
                                {
                                        System.out.println("Permits lodged at '" + tractName + "' with permit type 'Plumbing': " + area.countTractWithOfficeAndType("DataFile.csv", tractName, "Plumbing"));
					float amt = area.countTractWithOfficeAndType("DataFile.csv", tractName, "Plumbing");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 7)
                                {
                                        System.out.println("Permits lodged at '" + tractName + "' with permit type 'HVAC': " + area.countTractWithOfficeAndType("DataFile.csv", tractName, "HVAC"));
					float amt = area.countTractWithOfficeAndType("DataFile.csv", tractName, "HVAC");
					percCalc(total, amt);
                                        System.out.println("");
					
                                }
                                else if (a == 8)
                                {
                                        float eq1 = area.countTractWithOfficeAndType("DataFile.csv", tractName, "Electrical") + area.countTractWithOfficeAndType("DataFile.csv", tractName, "Plumbing") + area.countTractWithOfficeAndType("DataFile.csv", tractName, "HVAC");
                                        float eq2 = area.countAllWithTract("DataFile.csv", tractName) - eq1;
                                        System.out.println("Permits lodged at '" + tractName + "' with other permit types: " + eq2);
					percCalc(total, eq2);
                                        System.out.println("");
                                }
			
				
			}
			else if (choice == 9)
			{
				String cenTract = enterCensusTract();
                                selectStat();
                                int select = sc.nextInt();
                                int a = select;
				float total = areaa.countAllWithCenTract("DataFile.csv", cenTract);
                                if (a < 1 || a > 9)
                                {
                                        System.out.println("Invalid input, try again");


                                }
                                else if (a == 9)
                                {
                                        System.exit(0);
                                }
                                else if (a == 1)
                                {
                                        System.out.println("Permits lodged at '" + cenTract + "': "  + areaa.countAllWithCenTract("DataFile.csv", cenTract));
                                        System.out.println("");
                                }
                                else if (a == 2)
                                {
                                        System.out.println("Permits lodged at '" + cenTract + "' with status 'Permit Finaled': " + areaa.countCenTractWithOfficeAndStatus("DataFile.csv", cenTract, "Permit Finaled"));
					float amt = areaa.countCenTractWithOfficeAndStatus("DataFile.csv", cenTract, "Permit Finaled");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 3)
                                {
                                        System.out.println("Permits lodged at '" + cenTract + "' with status 'Issued': " + areaa.countCenTractWithOfficeAndStatus("DataFile.csv", cenTract, "Issued"));
					float amt = areaa.countCenTractWithOfficeAndStatus("DataFile.csv", cenTract, "Issued");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 4)
                                {
                                        float eq1 = areaa.countCenTractWithOfficeAndStatus("DataFile.csv", cenTract, "Permit Finaled") + areaa.countCenTractWithOfficeAndStatus("DataFile.csv", cenTract, "Issued");
                                        float eq2 = areaa.countAllWithCenTract("DataFile.csv", cenTract) - eq1;
                                        System.out.println("Permits lodged at '" + cenTract + "' with other status: " + eq2);
					percCalc(total, eq2);
					System.out.println("");
                                }
                                else if (a == 5)
                                {
                                        System.out.println("Permits lodged at '" + cenTract + "' with permit type 'Electrical': " + areaa.countCenTractWithOfficeAndType("DataFile.csv", cenTract, "Electrical"));
					float amt = areaa.countCenTractWithOfficeAndType("DataFile.csv", cenTract, "Electrical");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 6)
                                {
                                        System.out.println("Permits lodged at '" + cenTract + "' with permit type 'Plumbing': " + areaa.countCenTractWithOfficeAndType("DataFile.csv", cenTract, "Plumbing"));
					float amt = areaa.countCenTractWithOfficeAndType("DataFile.csv", cenTract, "Plumbing");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 7)
                                {
                                        System.out.println("Permits lodged at '" + cenTract + "' with permit type 'HVAC': " + areaa.countCenTractWithOfficeAndType("DataFile.csv", cenTract, "HVAC"));
					float amt = areaa.countCenTractWithOfficeAndType("DataFile.csv", cenTract, "HVAC");
					percCalc(total, amt);
                                        System.out.println("");

                                }
                                else if (a == 8)
                                {
                                        float eq1 = areaa.countCenTractWithOfficeAndType("DataFile.csv", cenTract, "Electrical") + areaa.countCenTractWithOfficeAndType("DataFile.csv", cenTract, "Plumbing") + areaa.countCenTractWithOfficeAndType("DataFile.csv", cenTract, "HVAC");
                                        float eq2 = areaa.countAllWithCenTract("DataFile.csv", cenTract) - eq1;
                                        System.out.println("Permits lodged at '" + cenTract + "' with other permit types: " + eq2);
					percCalc(total, eq2);
                                        System.out.println("");
                                }

			}
			else if (choice == 10)
			{
				String counDis = enterCounDistrict();
                                selectStat();
                                int select = sc.nextInt();
                                int a = select;
				float total = areaa.countAllWithCounDis("DataFile.csv", counDis);
                                if (a < 1 || a > 9)
                                {
                                        System.out.println("Invalid input, try again");


                                }
                                else if (a == 9)
                                {
                                        System.exit(0);
                                }
                                else if (a == 1)
                                {
                                        System.out.println("Permits lodged at '" + counDis + "': "  + areaa.countAllWithCounDis("DataFile.csv", counDis));
                                        System.out.println("");
                                }
                                else if (a == 2)
                                {
                                        System.out.println("Permits lodged at '" + counDis + "' with status 'Permit Finaled': " + areaa.countCounDistrictWithOfficeAndStatus("DataFile.csv", counDis, "Permit Finaled"));
					float amt = areaa.countCounDistrictWithOfficeAndStatus("DataFile.csv", counDis, "Permit Finaled");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 3)
                                {
                                        System.out.println("Permits lodged at '" + counDis + "' with status 'Issued': " + areaa.countCounDistrictWithOfficeAndStatus("DataFile.csv", counDis, "Issued"));
					float amt = areaa.countCounDistrictWithOfficeAndStatus("DataFile.csv", counDis, "Issued");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 4)
                                {
                                        float eq1 = areaa.countCounDistrictWithOfficeAndStatus("DataFile.csv", counDis, "Permit Finaled") + areaa.countCounDistrictWithOfficeAndStatus("DataFile.csv", counDis, "Issued");
                                        float eq2 = areaa.countAllWithCounDis("DataFile.csv", counDis) - eq1;
                                        System.out.println("Permits lodged at '" + counDis + "' with other status: " + eq2);
					percCalc(total, eq2);
					System.out.println("");
                                }
                                else if (a == 5)
                                {
                                        System.out.println("Permits lodged at '" + counDis + "' with permit type 'Electrical': " + areaa.countCounDistrictWithOfficeAndType("DataFile.csv", counDis, "Electrical"));
					float amt = areaa.countCounDistrictWithOfficeAndType("DataFile.csv", counDis, "Electrical");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 6)
                                {
                                        System.out.println("Permits lodged at '" + counDis + "' with permit type 'Plumbing': " + areaa.countCounDistrictWithOfficeAndType("DataFile.csv", counDis, "Plumbing"));
					float amt = areaa.countCounDistrictWithOfficeAndType("DataFile.csv", counDis, "Plumbing");
					percCalc(total, amt);
                                        System.out.println("");
                                }
                                else if (a == 7)
                                {
                                        System.out.println("Permits lodged at '" + counDis + "' with permit type 'HVAC': " + areaa.countCounDistrictWithOfficeAndType("DataFile.csv", counDis, "HVAC"));
					float amt = areaa.countCounDistrictWithOfficeAndType("DataFile.csv", counDis, "HVAC");
					percCalc(total, amt);
                                        System.out.println("");

                                }
                                else if (a == 8)
                                {
                                        float eq1 = areaa.countCounDistrictWithOfficeAndType("DataFile.csv", counDis, "Electrical") + areaa.countCounDistrictWithOfficeAndType("DataFile.csv", counDis, "Plumbing") + areaa.countCounDistrictWithOfficeAndType("DataFile.csv", counDis, "HVAC");
                                        float eq2 = areaa.countAllWithCounDis("DataFile.csv", counDis) - eq1;
                                        System.out.println("Permits lodged at '" + counDis + "' with other permit types: " + eq2);
					percCalc(total, eq2);
                                        System.out.println("");
                                }
			}



		
		}

	}
	public static void selectStat()
	{
		
		System.out.println("Please select from a statistic below: ");
		System.out.println("");
		System.out.println("1. > Total number of permits.\n" + "2. > Total number and percentage of permits with status 'Permit Finished'.\n" + "3. > Total number and percentage of permits with status 'Issued'.\n" + "4. > Total number and percentage of permits with any other status.\n" + "5. > Total number and percentage of permits with type 'Electrical'.\n" + "6. > Total number and percentage of permits with type 'Plumbing'.\n" + "7. > Total number and percentage of permits with type 'HVAC'.\n" + "8. > Total number and percentage of permits with any other type.\n" + "9. > Exit");
		System.out.print("Enter: ");
		
		
	}
	public static String enterTract()
	{
		System.out.print("Enter a Tract: ");
		Scanner sc = new Scanner(System.in);
		String tractName = sc.nextLine();
		return tractName;
	}
	public static String enterCensusTract()
	{
		System.out.print("Enter Census Tract: ");
		Scanner sc = new Scanner(System.in);
		String cenTract = sc.nextLine();
		return cenTract;
	}
	public static String enterCounDistrict()
	{
		System.out.print("Enter Council District: ");
		Scanner sc = new Scanner(System.in);
		String CounDis = sc.nextLine();
		return CounDis;
	}
	public static void percCalc(float total, float amt)
	{
		float ptage = (amt / total) * 100;
		System.out.println("Percentage of permits: " + ptage + "%");
	}
	

}
class Permit
{
	private String permitNumber = "";
	private String permitType = "";
	private String tractName = "";
	private String status = "";
	private String initiatingOffice = "";
	private int licenseNumber = 0;
	private double latitude;
	private double longitude;

	public static float countAll(String pFileName)
	{
		FileInputStream fileStream = null;
		InputStreamReader rdr;
		BufferedReader bufRdr;
		int count;
		count = 0;
		String line;
		try
		{
			fileStream = new FileInputStream(pFileName);
			rdr = new InputStreamReader(fileStream);
			bufRdr = new BufferedReader(rdr);
			line = bufRdr.readLine();
			while (line != null)
			{
				count++;
				line = bufRdr.readLine();

			}
				fileStream.close();
		}
		catch (IOException errorDetails)
		{
			if (fileStream != null)
			{	
				try
				{
					fileStream.close();
				}
			
				catch (IOException ex2)
				{}
			}
			System.out.println("Error in file processing: " + errorDetails.getMessage());		     }
		return count;


	}
	public float countAllWithStatus(String pFileName, String perStatus)
        {
                FileInputStream fileStream = null;
                InputStreamReader rdr;
                BufferedReader bufRdr;
                float count;
                count = 0;
                String line;
		status = perStatus;
                try
                {
                        fileStream = new FileInputStream(pFileName);
                        rdr = new InputStreamReader(fileStream);
                        bufRdr = new BufferedReader(rdr);
                        line = bufRdr.readLine();
                        while (line != null)
                        {
				if (line.contains(status))
				count++;
                                line = bufRdr.readLine();
				
                        }
                                fileStream.close();
                }
                catch (IOException errorDetails)
                {
                        if (fileStream != null)
                        {
                                try
                                {
                                        fileStream.close();
                                }

                                catch (IOException ex2)
                                {}
                        }
                        System.out.println("Error in file processing: " + errorDetails.getMessage());                }
                return count;


        }
	public float countWithOfficeAndStatus(String pFileName, String office, String perStatus)
	{
		FileInputStream fileStream = null;
		InputStreamReader rdr;
		BufferedReader bufRdr;
		int count;
		count = 0;
		String line;
		initiatingOffice = office;
		status = perStatus;
		try
		{
			fileStream = new FileInputStream(pFileName);
			rdr = new InputStreamReader(fileStream);
			bufRdr = new BufferedReader(rdr);
			line = bufRdr.readLine();
			while (line != null)
			{
				if (line.contains(initiatingOffice) && line.contains(status))
				count++;
				line = bufRdr.readLine();
				
			}
				fileStream.close();
		}
		catch(IOException errorDetails)
		{
			if (fileStream != null)
			{
				try
				{
					fileStream.close();
				}
				catch (IOException ex2)
				{ }
			}
			System.out.println("Error in file processing: " + errorDetails.getMessage());
		}
		return count;
	}

	public float countWithOfficeAndType(String pFileName, String office, String perType)
        {
                FileInputStream fileStream = null;
                InputStreamReader rdr;
                BufferedReader bufRdr;
                int count;
                count = 0;
                String line;
                initiatingOffice = office;
                permitType = perType;
                try
                {
                        fileStream = new FileInputStream(pFileName);
                        rdr = new InputStreamReader(fileStream);
                        bufRdr = new BufferedReader(rdr);
                        line = bufRdr.readLine();
                        while (line != null)
                        {
                                if (line.contains(office) && line.contains(permitType))
                                count++;
                                line = bufRdr.readLine();

                        }
                                fileStream.close();
                }
                catch(IOException errorDetails)
                {
                        if (fileStream != null)
                        {
                                try
                                {
                                        fileStream.close();
                                }
                                catch (IOException ex2)
                                { }
                        }
                        System.out.println("Error in file processing: " + errorDetails.getMessage());
                }
                return count;
	}
	public float countOfPermits(String pFileName, String office)
        {
                FileInputStream fileStream = null;
                InputStreamReader rdr;
                BufferedReader bufRdr;
                int count;
                count = 0;
                String line;
                initiatingOffice = office;
                try
                {
                        fileStream = new FileInputStream(pFileName);
                        rdr = new InputStreamReader(fileStream);
                        bufRdr = new BufferedReader(rdr);
                        line = bufRdr.readLine();
                        while (line != null)
                        {
                                if (line.contains(office))
                                count++;
                                line = bufRdr.readLine();

                        }
                                fileStream.close();
                }
                catch(IOException errorDetails)
                {
                        if (fileStream != null)
                        {
                                try
                                {
                                        fileStream.close();
                                }
                                catch (IOException ex2)
                                { }
                        }
                        System.out.println("Error in file processing: " + errorDetails.getMessage());
                }
                return count;

        }

	public float typeOfPermit(String pFileName, String type)
        {
                FileInputStream fileStream = null;
                InputStreamReader rdr;
                BufferedReader bufRdr;
                int count;
                count = 0;
                String line;
		permitType = type;
                try
                {
                        fileStream = new FileInputStream(pFileName);
                        rdr = new InputStreamReader(fileStream);
                        bufRdr = new BufferedReader(rdr);
                        line = bufRdr.readLine();
                        while (line != null)
                        {
                                if (line.contains(permitType))
                                count++;
                                line = bufRdr.readLine();

                        }
                                fileStream.close();
                }
                catch(IOException errorDetails)
                {
                        if (fileStream != null)
                        {
                                try
                                {
                                        fileStream.close();
                                }
                                catch (IOException ex2)
                                { }
                        }
                        System.out.println("Error in file processing: " + errorDetails.getMessage());
                }
                return count;
        }
	public float countAllWithTract(String pFileName, String tract)
        {
                FileInputStream fileStream = null;
                InputStreamReader rdr;
                BufferedReader bufRdr;
                float count;
                count = 0;
                String line;
                tractName = tract;
                try
                {
                        fileStream = new FileInputStream(pFileName);
                        rdr = new InputStreamReader(fileStream);
                        bufRdr = new BufferedReader(rdr);
                        line = bufRdr.readLine();
                        while (line != null)
                        {
                                if (line.contains(tractName))
                                count++;
                                line = bufRdr.readLine();

                        }
                                fileStream.close();
                }
                catch (IOException errorDetails)
                {
                        if (fileStream != null)
                        {
                                try
                                {
                                        fileStream.close();
                                }

                                catch (IOException ex2)
                                {}
                        }
                        System.out.println("Error in file processing: " + errorDetails.getMessage());
		}
                return count;


        }

	public float countTractWithOfficeAndStatus(String pFileName, String tract, String perStatus)
        {
                FileInputStream fileStream = null;
                InputStreamReader rdr;
                BufferedReader bufRdr;
                int count;
                count = 0;
                String line;
                tractName = tract;
                status = perStatus;
                try
                {
                        fileStream = new FileInputStream(pFileName);
                        rdr = new InputStreamReader(fileStream);
                        bufRdr = new BufferedReader(rdr);
                        line = bufRdr.readLine();
                        while (line != null)
                        {
                                if (line.contains(tractName) && line.contains(status))
                                count++;
                                line = bufRdr.readLine();

                        }
                                fileStream.close();
                }
                catch(IOException errorDetails)
                {
                        if (fileStream != null)
                        {
                                try
                                {
                                        fileStream.close();
                                }
                                catch (IOException ex2)
                                { }
                        }
                        System.out.println("Error in file processing: " + errorDetails.getMessage());
                }
                return count;

        }
	public float countTractWithOfficeAndType(String pFileName, String tract, String type)
        {
                FileInputStream fileStream = null;
                InputStreamReader rdr;
                BufferedReader bufRdr;
                int count;
                count = 0;
                String line;
                tractName = tract;
                permitType = type;
                try
                {
                        fileStream = new FileInputStream(pFileName);
                        rdr = new InputStreamReader(fileStream);
                        bufRdr = new BufferedReader(rdr);
                        line = bufRdr.readLine();
                        while (line != null)
                        {
                                if (line.contains(tractName) && line.contains(status))
                                count++;
                                line = bufRdr.readLine();

                        }
                                fileStream.close();
                }
                catch(IOException errorDetails)
                {
                        if (fileStream != null)
                        {
                                try
                                {
                                        fileStream.close();
                                }
                                catch (IOException ex2)
                                { }
                        }
                        System.out.println("Error in file processing: " + errorDetails.getMessage());
                }
                return count;

        }

	class Area
	{
		private String censusTract;
		private String councilDistrict;
		


		public float countAllWithCenTract(String pFileName, String cenTract)
        	{
                	FileInputStream fileStream = null;
                	InputStreamReader rdr;
                	BufferedReader bufRdr;
                	float count;
                	count = 0;
                	String line;
                	censusTract = cenTract;
                	try
                	{
                        	fileStream = new FileInputStream(pFileName);
                        	rdr = new InputStreamReader(fileStream);
                        	bufRdr = new BufferedReader(rdr);
                        	line = bufRdr.readLine();
                        	while (line != null)
                        	{
                                	if (line.contains(censusTract))
                                	count++;
                                	line = bufRdr.readLine();

                        	}
                                	fileStream.close();
                	}
                	catch (IOException errorDetails)
                	{
                        	if (fileStream != null)
                        	{
                                	try
                                	{
                                        	fileStream.close();
                                	}

                                	catch (IOException ex2)
                                	{}
                        	}
                        	System.out.println("Error in file processing: " + errorDetails.getMessage());
                	}
                	return count;


        	}
		public float countCenTractWithOfficeAndStatus(String pFileName, String cenTract, String perStatus)
        	{
                	FileInputStream fileStream = null;
                	InputStreamReader rdr;
                	BufferedReader bufRdr;
                	int count;
                	count = 0;
                	String line;
                	censusTract = cenTract;
                	status = perStatus;
                	try
                	{
                        	fileStream = new FileInputStream(pFileName);
                        	rdr = new InputStreamReader(fileStream);
                        	bufRdr = new BufferedReader(rdr);
                        	line = bufRdr.readLine();
                        	while (line != null)
                        	{
                                	if (line.contains(censusTract) && line.contains(status))
                                	count++;
                                	line = bufRdr.readLine();

                        	}
                                	fileStream.close();
                	}
                	catch(IOException errorDetails)
                	{
                        	if (fileStream != null)
                        	{
                                	try
                                	{
                                        	fileStream.close();
					}
                                	catch (IOException ex2)
                                	{ }
                        	}
                        	System.out.println("Error in file processing: " + errorDetails.getMessage());
                	}
                	return count;

        	}

		public float countCenTractWithOfficeAndType(String pFileName, String cenTract, String type)
        	{
                	FileInputStream fileStream = null;
                	InputStreamReader rdr;
                	BufferedReader bufRdr;
                	int count;
                	count = 0;
                	String line;
                	censusTract = cenTract;
                	permitType = type;
                	try
                	{
                        	fileStream = new FileInputStream(pFileName);
                        	rdr = new InputStreamReader(fileStream);
                        	bufRdr = new BufferedReader(rdr);
                        	line = bufRdr.readLine();
                        	while (line != null)
                        	{
                                	if (line.contains(censusTract) && line.contains(permitType))
                                	count++;
                                	line = bufRdr.readLine();

                        	}
                                	fileStream.close();
                	}
                	catch(IOException errorDetails)
                	{
                        	if (fileStream != null)
                        	{
                                	try
                                	{
                                        	fileStream.close();
                                	}
                                	catch (IOException ex2)
                                	{ }
                        	}
                        	System.out.println("Error in file processing: " + errorDetails.getMessage());
                	}
                	return count;

        	}
		public float countAllWithCounDis(String pFileName, String counDis)
                {
                        FileInputStream fileStream = null;
                        InputStreamReader rdr;
                        BufferedReader bufRdr;
                        float count;
                        count = 0;
                        String line;
                        councilDistrict = counDis;
                        try
                        {
                                fileStream = new FileInputStream(pFileName);
                                rdr = new InputStreamReader(fileStream);
                                bufRdr = new BufferedReader(rdr);
                                line = bufRdr.readLine();
                                while (line != null)
                                {
                                        if (line.contains(councilDistrict))
                                        count++;
                                        line = bufRdr.readLine();

                                }
                                        fileStream.close();
                        }
                        catch (IOException errorDetails)
                        {
                                if (fileStream != null)
                                {
                                        try
                                        {
                                                fileStream.close();
                                        }

                                        catch (IOException ex2)
                                        {}
                                }
                                System.out.println("Error in file processing: " + errorDetails.getMessage());
                        }
                        return count;
		}

		public float countCounDistrictWithOfficeAndStatus(String pFileName, String counDis, String perStatus)
                {
                        FileInputStream fileStream = null;
                        InputStreamReader rdr;
                        BufferedReader bufRdr;
                        int count;
                        count = 0;
                        String line;
                        councilDistrict = counDis;
                        status = perStatus;
                        try
                        {
                                fileStream = new FileInputStream(pFileName);
                                rdr = new InputStreamReader(fileStream);
                                bufRdr = new BufferedReader(rdr);
                                line = bufRdr.readLine();
                                while (line != null)
                                {
                                        if (line.contains(councilDistrict) && line.contains(status))
                                        count++;
                                        line = bufRdr.readLine();

                                }
                                        fileStream.close();
                        }
                        catch(IOException errorDetails)
                        {
                                if (fileStream != null)
                                {
                                        try
                                        {
                                                fileStream.close();
                                        }
                                        catch (IOException ex2)
                                        { }
                                }
                                System.out.println("Error in file processing: " + errorDetails.getMessage());
                        }
                        return count;

                }
		public float countCounDistrictWithOfficeAndType(String pFileName, String counDis, String type)
                {
                        FileInputStream fileStream = null;
                        InputStreamReader rdr;
                        BufferedReader bufRdr;
                        int count;
                        count = 0;
                        String line;
                        councilDistrict = counDis;
                        permitType = type;
                        try
                        {
                                fileStream = new FileInputStream(pFileName);
                                rdr = new InputStreamReader(fileStream);
                                bufRdr = new BufferedReader(rdr);
                                line = bufRdr.readLine();
                                while (line != null)
                                {
                                        if (line.contains(councilDistrict) && line.contains(permitType))
                                        count++;
                                        line = bufRdr.readLine();

                                }
                                        fileStream.close();
                        }
                        catch(IOException errorDetails)
                        {
                                if (fileStream != null)
                                {
                                        try
                                        {
                                                fileStream.close();
                                        }
                                        catch (IOException ex2)
                                        { }
                                }
                                System.out.println("Error in file processing: " + errorDetails.getMessage());
                        }
                        return count;

                }



	}


}

