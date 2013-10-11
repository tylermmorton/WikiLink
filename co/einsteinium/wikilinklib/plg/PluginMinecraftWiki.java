package co.einsteinium.wikilinklib.plg;

import java.util.ArrayList;
import java.util.HashMap;

import co.einsteinium.wikilink.api.Plugin;

public class PluginMinecraftWiki implements Plugin
{
    @Override
    public String getWikiDisplay()
    {
        // TODO Auto-generated method stub
        return "Minecraft Wiki";
    }

    @Override
    public String getModID()
    {
        // TODO Auto-generated method stub
        return "Minecraft";
    }

    @Override
    public String getWikiDomain()
    {
        // TODO Auto-generated method stub
        return "www.minecraftwiki.net";
    }

    @Override
    public Software getWikiSoftware()
    {
        // TODO Auto-generated method stub
        return Software.MEDIAWIKI;
    }

    @Override
    public String getWikiLocalization()
    {
        // TODO Auto-generated method stub
        return "ALL";
    }

	@Override
	public HashMap<Integer, String> getItemStackVideos()
	{
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
			map.put(2, "58gIIDWHccQ");
			map.put(3, "2FSF3xDI2XA");
			map.put(7, "4LBvjciCg7w");
			map.put(12, "3DJ6F2r8LI0");
			map.put(13, "Bq7lCUoT-NA");
			map.put(14, "1T_v_ctrNjQ");
			map.put(15, "1T_v_ctrNjQ");
			map.put(16, "1T_v_ctrNjQ");
			map.put(21, "1T_v_ctrNjQ");
			map.put(22, "DQLZutoAKzI");
			map.put(27, "BqSNAD9CtTI");
			map.put(28, "ILy1jrm_GUw");
			map.put(30, "Mcy838AG4FI");
			map.put(31, "L8hj19BswZU");
			map.put(32, "Py8ffkhfTAo");
			map.put(35, "qTSsxB9dEts");
			map.put(37, "d22hh9vwuQE");
			map.put(38, "d22hh9vwuQE");
			map.put(39, "wfdKfxcmGb8");
			map.put(40, "wfdKfxcmGb8");
			map.put(41, "H-L_0Uu5dgo");
			map.put(44, "7iGYt_RCO24");
			map.put(46, "6i4a9ANfgck");
			map.put(50, "INvdAxmdbmQ");
			map.put(54, "CZFSdifVHqA");
			map.put(56, "1T_v_ctrNjQ");
			map.put(58, "l5oBxynPNDk");
			map.put(60, "R-4ytK9Xt2M");
			map.put(61, "kU0Y6nDwY_o");
			map.put(66, "ILy1jrm_GUw");
			map.put(69, "sw2IV7nL5nk");
			map.put(70, "XUs0u8UFhuA");
			map.put(72, "XUs0u8UFhuA");
			map.put(73, "1T_v_ctrNjQ");
			map.put(77, "39TcDKbJJ3A");
			map.put(78, "rheu7lwwPT4");
			map.put(79, "b8eaIFoqEBs");
			map.put(80, "AgVjRdZvJyc");
			map.put(81, "_BDblH0hbC8");
			map.put(82, "rPdSC4dhwRQ");
			map.put(84, "3n3StSma5cg");
			map.put(85, "pmKdBrAxty0");
			map.put(86, "luYVUXvnr58");
			map.put(87, "ppNrtvwQXNw");
			map.put(88, "_3HBzqU9Nak");
			map.put(89, "f1fByIfph4Y");
			map.put(91, "f4ts1nE6O7M");
			map.put(92, "Yiq7bsdDH1M");
			map.put(96, "RlTmkLf2_ME");
			map.put(102, "pOhZ42FpaEs");
			map.put(103, "c5jytCPxudQ");
			map.put(106, "H-ZxE64Xxbc");
			map.put(107, "-UhSLyhm8b0");
			map.put(111, "ePJ_QjyA5DI");
			map.put(112, "izjVkhl-xaU");
			map.put(120, "ATWR4KHgI9w");
			map.put(121, "ZAHb2rnXQuE");
			map.put(123, "pjO4dp7j5ks");	
			map.put(127, "QHFJhZlinW8");
			map.put(129, "S1VUpeRZ8gc");
			map.put(131, "OjciuikGFRo");
			map.put(133, "ufeUa4PMuZc");
			map.put(138, "F_ijYaiwGUQ");
			map.put(139, "DlznsEWr9rs");
			map.put(143, "39TcDKbJJ3A");
			map.put(145, "iLJ07VACdp0");
			map.put(146, "EU7VmXeutc0");
			map.put(147, "Ps7gxthhM-w");
			map.put(148, "Ps7gxthhM-w");
			map.put(151, "ggDUkPHXwXM");
			map.put(152, "F55d2cmNQi4");
			map.put(153, "AFLpldCIBRc");	
			map.put(154, "XO0IKUsGiG8");
			map.put(155, "J4J_FLWV0A0");
			map.put(157, "rgQD8Ps0wKs");	
			map.put(158, "B8i3BEnlmv8");
			map.put(159, "cvi5kjjIcg0");		
			map.put(170, "ix5P7uPc79s");
			map.put(171, "DNZ9d-KRR7U");			
			map.put(172, "I2-5aaqRJHA");
			map.put(173, "DmnNJMsxNEE");
			map.put(256, "U4X-4S4neYM");
			map.put(257, "G_HTViy2JTo");
			map.put(258, "0lgu-DzXh2Y");
			map.put(259, "caz8BBG48VU");
			map.put(260, "p3-mnfOHiIA");
			map.put(261, "6bv6HlzMuvY");
			map.put(262, "STQkD1Oa65s");
			map.put(263, "69oWRhL2d5Y");
			map.put(264, "h9xb00Pcf0U");
			map.put(265, "Fuk9NxeXrq4");
			map.put(266, "H-L_0Uu5dgo");
			map.put(267, "g5KtaUUU7Sw");
			map.put(268, "g5KtaUUU7Sw");
			map.put(269, "U4X-4S4neYM");
			map.put(270, "G_HTViy2JTo");
			map.put(271, "0lgu-DzXh2Y");
			map.put(272, "g5KtaUUU7Sw");
			map.put(273, "U4X-4S4neYM");
			map.put(274, "G_HTViy2JTo");
			map.put(275, "0lgu-DzXh2Y");
			map.put(276, "g5KtaUUU7Sw");
			map.put(277, "U4X-4S4neYM");
			map.put(278, "G_HTViy2JTo");
			map.put(279, "0lgu-DzXh2Y");
			map.put(280, "SYoHAJBuoss");
			map.put(282, "a3mL9TCRqrU");
			map.put(283, "g5KtaUUU7Sw");
			map.put(284, "U4X-4S4neYM");
			map.put(285, "G_HTViy2JTo");
			map.put(286, "0lgu-DzXh2Y");
			map.put(290, "Wkqfv6QLEs0");
			map.put(291, "Wkqfv6QLEs0");
			map.put(292, "Wkqfv6QLEs0");
			map.put(293, "Wkqfv6QLEs0");
			map.put(294, "Wkqfv6QLEs0");
			map.put(297, "Yiq7bsdDH1M");
			map.put(296, "JbAURiYQZlA");
			map.put(318, "gLncqobU3TY");
			map.put(319, "dreP7SLG37A");
			map.put(320, "dreP7SLG37A");
			map.put(322, "bYGMiPZhxDE");
			map.put(323, "kyK5UP3soNQ");
			map.put(324, "dMOpqzlLtFk");
			map.put(328, "gr7mIHYCrkw");
			map.put(329, "zaVePE895p0");
			map.put(330, "dMOpqzlLtFk");
			map.put(331, "_IApwvCLJW8");
			map.put(332, "2E-c9P8kyfg");
			map.put(335, "eyxea_d0b3s");
			map.put(337, "8FXeb-ZYrr4");
			map.put(339, "_kFYX_pAze4");
			map.put(340, "UGJBUhxwKy0");
			map.put(341, "J6oR3fdbbjY");
			map.put(342, "2yVVMiQrCwo");	
			map.put(343, "CUa8KZx4hmk");
			map.put(344, "8rDbF8UYuTc");
			map.put(345, "ys8hchT3gvE");
			map.put(346, "d0JGyVuqvYE");
			map.put(347, "Q3bsT84oVz4");
			map.put(349, "ybNl3R02MK8");
			map.put(350, "ybNl3R02MK8");
			map.put(351, "8YD7oauNZHE");
			map.put(352, "lhE36Eg9Rd4");
			map.put(354, "Yiq7bsdDH1M");
			map.put(355, "pTc_tuKcvNE");
			map.put(356, "0Ij_qMLiRzE");
			map.put(357, "SW5QIs_M0po");
			map.put(358, "4eZJepHxJh0");			
			map.put(359, "XorXnFXz-WU");
			map.put(360, "c5jytCPxudQ");
			map.put(362, "h5MXG4aW5ak");
			map.put(363, "PCbLQPXiNYo");		
			map.put(364, "PCbLQPXiNYo");
			map.put(365, "ux362Ae8Llc");
			map.put(366, "ux362Ae8Llc");
			map.put(367, "xTrUEVoe9Tw");
			map.put(368, "E0AhoxYLomc");
			map.put(370, "BE5fKAV1g60");
			map.put(371, "OtmyEV-s_Aw");
			map.put(372, "_XExLXCQtg4");
			map.put(373, "CFBb-HgBL7g");
			map.put(377, "FSP2qBpe9vI");
			map.put(381, "E0AhoxYLomc");
			map.put(385, "IiCTxsHg6SQ");
			map.put(386, "DD_Z82wmGZA");
			map.put(388, "lYvQ-qFiorA");
			map.put(391, "ETYH9tTKqHw");
			map.put(392, "G-40EB-fNv8");
			map.put(393, "bQmn0IqdhUc");
			map.put(394, "bQmn0IqdhUc");
			map.put(395, "4eZJepHxJh0");
			map.put(396, "HJUaKroydLQ");
			map.put(397, "2iPuDRjwQ2o");
			map.put(398, "V7IVYX5Bs48");
			map.put(399, "H6k28iUefMo");
			map.put(400, "IjeeTE117HM");
			map.put(401, "6h_Mx4PZ0PA");
			map.put(402, "fYL1W9aW0UU");
			map.put(404, "J7Z20Zzz3yU");
			map.put(405, "JvB2RhbL0j4");
			map.put(407, "1yNgY913tps");
			map.put(406, "7gVMNQVaZGU");
			map.put(408, "I5etC7LeCac");
			map.put(421, "_2sny71Spro");
			
		return map;
	}
	
	@Override
	public HashMap<Integer, String> getItemStackDisplay()
	{
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
			map.put(0, "Item Spotlight (mcspotlights)");
		
		return map;
	}
}
