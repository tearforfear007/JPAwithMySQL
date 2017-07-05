
import java.util.List;

import tzuchi.donation.da.MemberDA;
import tzuchi.donation.orm.DonationVO;
import tzuchi.donation.orm.MemberVO;

public class Main {

	public static void main(String[] args) {

		MemberDA da = new MemberDA();
		List<MemberVO> list = da.queryAll();
		int totalAmount = 0;

		for (MemberVO vo : list) {
			System.out.print("�|�����G");
			System.out.println(vo.getMember_id() + "  �m�W�G" + vo.getName() + "  �����Ҧr���G" + vo.getUid());

			System.out.println("========����========");
			for (DonationVO ds : vo.getDonations()) {
				totalAmount = totalAmount + ds.getAmount();
				System.out.print("���B�G " + ds.getAmount().toString());
				System.out.println(" ���ڤ���G " + ds.getDate().toString());
			}

			// Query from donate table
//			DonationDA donationDA = new DonationDA();
//			List<DonationVO> donationlist = donationDA.queryOne(vo.getMember_id());
//			for (DonationVO donationVO : donationlist) {
				// Inverse query for Member info
//				System.out.print(donationVO.getMember().getName() + " ");
//				System.out.print(donationVO.getMember().getUid() + " ");
//				System.out.print(donationVO.getMember().getMember_id() + " ");
//				System.out.println("���ڤ��:" + donationVO.getDate().toString() + " ���B:" + donationVO.getAmount());
//			}
			System.out.println("------�����`�p�G"+totalAmount+"------\n");
			totalAmount = 0;
		}

	}

}
