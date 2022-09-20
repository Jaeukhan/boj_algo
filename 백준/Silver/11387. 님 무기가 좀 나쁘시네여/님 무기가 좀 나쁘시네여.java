import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Character kri = new Character(Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		Character paboo = new Character(Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		Character kriweapon = new Character(Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		Character pabooweapon = new Character(Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()));
		double beforekri = Powercal(kri.ad,kri.pow,kri.criper,kri.cridam,kri.attackspeed);
		double afterkri = Powercal(kri.ad-kriweapon.ad+pabooweapon.ad,
				kri.pow-kriweapon.pow+pabooweapon.pow,
				kri.criper-kriweapon.criper+pabooweapon.criper,
				kri.cridam-kriweapon.cridam+pabooweapon.cridam,
				kri.attackspeed-kriweapon.attackspeed+pabooweapon.attackspeed);
		check((int)beforekri, (int)afterkri);
		double beforepaboo = Powercal(paboo.ad,paboo.pow,paboo.criper,paboo.cridam,paboo.attackspeed);
		double afterpaboo = Powercal(paboo.ad+kriweapon.ad-pabooweapon.ad,
				paboo.pow+kriweapon.pow-pabooweapon.pow,
				paboo.criper+kriweapon.criper-pabooweapon.criper,
				paboo.cridam+kriweapon.cridam-pabooweapon.cridam,
				paboo.attackspeed+kriweapon.attackspeed-pabooweapon.attackspeed);
		check((int)beforepaboo, (int)afterpaboo);
	}
	static void check(int before, int after) {
		if(before<after) System.out.println("+");
		else if(before>after) System.out.println("-");
		else System.out.println("0");
	}
//	static double Powercal(int ad, int pow, int criper, int cridam, int attackspeed) {
//		return ad * (100+pow)*((100-min(criper, 100))+min(criper, 100)*(cridam))
//				*(100+(attackspeed));
//	}
	static double Powercal(int ad, int pow, int criper, int cridam, int attackspeed) {
		return ad * (1.0+pow/100.0)*((1.0-Math.min(criper/100.0, 1.0))+Math.min(criper/100.0, 1.0)*(cridam/100.0))
				*(1.0+(attackspeed/100.0));
	}

	public static class Character{
		int ad,  pow,  criper,  cridam,  attackspeed;

		public Character(int ad, int pow, int criper, int cridam, int attackspeed) {
			this.ad = ad;
			this.pow = pow;
			this.criper = criper;
			this.cridam = cridam;
			this.attackspeed = attackspeed;
		}
	}
}