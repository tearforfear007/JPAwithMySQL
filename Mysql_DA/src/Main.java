
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
			System.out.print("會員號：");
			System.out.println(vo.getMember_id() + "  姓名：" + vo.getName() + "  身份證字號：" + vo.getUid());

			System.out.println("========捐款========");
			for (DonationVO ds : vo.getDonations()) {
				totalAmount = totalAmount + ds.getAmount();
				System.out.print("金額： " + ds.getAmount().toString());
				System.out.println(" 捐款日期： " + ds.getDate().toString());
			}

			// Query from donate table
//			DonationDA donationDA = new DonationDA();
//			List<DonationVO> donationlist = donationDA.queryOne(vo.getMember_id());
//			for (DonationVO donationVO : donationlist) {
				// Inverse query for Member info
//				System.out.print(donationVO.getMember().getName() + " ");
//				System.out.print(donationVO.getMember().getUid() + " ");
//				System.out.print(donationVO.getMember().getMember_id() + " ");
//				System.out.println("捐款日期:" + donationVO.getDate().toString() + " 金額:" + donationVO.getAmount());
//			}
			System.out.println("------捐款總計："+totalAmount+"------\n");
			totalAmount = 0;
		}

	}

}
