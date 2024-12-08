//PostalCodes.java
//IFT2255 - Équipe 15
//Enum pour les codes postaux

public enum PostalCodes {
	 H1A(Quartiers.RiviereDesPrairiesPointeAuxTrembles),
	 H1C(Quartiers.RiviereDesPrairiesPointeAuxTrembles),
	 H1E(Quartiers.RiviereDesPrairiesPointeAuxTrembles),
	 H1B(Quartiers.RiviereDesPrairiesPointeAuxTrembles),
	 
	 H3P(Quartiers.MontRoyal),
	 H3R(Quartiers.MontRoyal),
	 H4P(Quartiers.MontRoyal),
	 
	 H2H(Quartiers.LePlateauMontRoyal),
	 H2J(Quartiers.LePlateauMontRoyal),
	 H2T(Quartiers.LePlateauMontRoyal),
	 H2W(Quartiers.LePlateauMontRoyal),

	 H2A(Quartiers.VilleraySaintMichelParcExtension),
	 H2E(Quartiers.VilleraySaintMichelParcExtension),
	 H3N(Quartiers.VilleraySaintMichelParcExtension),
	 H2P(Quartiers.VilleraySaintMichelParcExtension),
	 H2R(Quartiers.VilleraySaintMichelParcExtension),
	 H1Z(Quartiers.VilleraySaintMichelParcExtension),

	 H3A(Quartiers.VilleMarie),
	 H5A(Quartiers.VilleMarie),
	 H3B(Quartiers.VilleMarie),
	 H5B(Quartiers.VilleMarie),
	 H3C(Quartiers.VilleMarie),
	 H3G(Quartiers.VilleMarie),
	 H2K(Quartiers.VilleMarie),
	 H2L(Quartiers.VilleMarie),
	 H2X(Quartiers.VilleMarie),
	 H2Y(Quartiers.VilleMarie),
	 H2Z(Quartiers.VilleMarie),
	 H4Z(Quartiers.VilleMarie),

	 H4A(Quartiers.CoteDesNeigesNotreDameDeGrace),
	 H4B(Quartiers.CoteDesNeigesNotreDameDeGrace),
	 H3H(Quartiers.CoteDesNeigesNotreDameDeGrace),
	 H3S(Quartiers.CoteDesNeigesNotreDameDeGrace),
	 H3T(Quartiers.CoteDesNeigesNotreDameDeGrace),
	 H3V(Quartiers.CoteDesNeigesNotreDameDeGrace),
	 H3W(Quartiers.CoteDesNeigesNotreDameDeGrace),

	 H2B(Quartiers.AhuntsicCartierville),
	 H2C(Quartiers.AhuntsicCartierville),
	 H4J(Quartiers.AhuntsicCartierville),
	 H4K(Quartiers.AhuntsicCartierville),
	 H3L(Quartiers.AhuntsicCartierville),
	 H2M(Quartiers.AhuntsicCartierville),
	 H3M(Quartiers.AhuntsicCartierville),
	 H2N(Quartiers.AhuntsicCartierville),

	 H4C(Quartiers.LeSudOuest),
	 H4E(Quartiers.LeSudOuest),
	 H3J(Quartiers.LeSudOuest),
	 H3K(Quartiers.LeSudOuest),

	 H9C(Quartiers.lIleBizard),
	 H9E(Quartiers.lIleBizard),

	 H3E(Quartiers.Verdun),
	 H4G(Quartiers.Verdun),
	 H4H(Quartiers.Verdun),

	 H1G(Quartiers.MontrealNord),
	 H1H(Quartiers.MontrealNord),

	 H2G(Quartiers.Rosemont),
	 H2S(Quartiers.Rosemont),
	 H1T(Quartiers.Rosemont),
	 H1X(Quartiers.Rosemont),
	 H1Y(Quartiers.Rosemont),

	 H9H(Quartiers.Pierrefonds),
	 H9K(Quartiers.Pierrefonds),
	 H8Y(Quartiers.Pierrefonds),
	 H8Z(Quartiers.Pierrefonds),

	 H1J(Quartiers.Anjou),
	 H1K(Quartiers.Anjou),

	 H1L(Quartiers.Mercier),
	 H1M(Quartiers.Mercier),
	 H1N(Quartiers.Mercier),
	 H1V(Quartiers.Mercier),
	 H1W(Quartiers.Mercier),

	 H4L(Quartiers.SaintLaurent),
	 H4M(Quartiers.SaintLaurent),
	 H4N(Quartiers.SaintLaurent),
	 H4S(Quartiers.SaintLaurent),
	 H4T(Quartiers.SaintLaurent),

	 H8N(Quartiers.LaSalle),
	 H8P(Quartiers.LaSalle),
	 H8R(Quartiers.LaSalle),

	 H1P(Quartiers.SaintLeonard),
	 H1R(Quartiers.SaintLeonard),
	 H1S(Quartiers.SaintLeonard),

	 H8S(Quartiers.Lachine),
	 H8T(Quartiers.Lachine),

	 H2V(Quartiers.Outremont),

	 H3X(Quartiers.CoteSaintLuc),
	 H4V(Quartiers.CoteSaintLuc),
	 H4W(Quartiers.CoteSaintLuc),
	 H4X(Quartiers.CoteSaintLuc),

	 H3Y(Quartiers.Westmont),
	 H3Z(Quartiers.Westmont),

	 H4Y(Quartiers.Dorval);

	private final Quartiers quartier;
	
	PostalCodes(Quartiers quartier){
		this.quartier = quartier;
	}

	public Quartiers getQuartier(){
		return this.quartier;
	}

	public static void main(String[] args){
		System.out.println(PostalCodes.valueOf(args[0]).getQuartier().name());
	}
}






