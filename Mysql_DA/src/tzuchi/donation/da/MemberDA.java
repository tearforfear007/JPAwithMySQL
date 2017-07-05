package tzuchi.donation.da;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import tzuchi.donation.orm.DonationVO;
import tzuchi.donation.orm.MemberVO;
import tzuchi.donation.util.JPAUtil;

@SuppressWarnings("unchecked")
public class MemberDA {
	private EntityManager em;

	public List<MemberVO> queryAll() {
		List<MemberVO> resultList = null;
		em = JPAUtil.getEntityManagerFactory().createEntityManager();

		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append("select m from MemberVO m");

		try {
			Query query = em.createQuery(sqlBuf.toString());

			resultList = query.getResultList();
			 for (MemberVO memberVO:resultList){
				 Set<DonationVO> myDonationVO = memberVO.getDonations();
				 for(DonationVO donationVO:myDonationVO){
//					 System.out.println(donationVO.getAmount());
				 }
			 }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return resultList;
	}
}
