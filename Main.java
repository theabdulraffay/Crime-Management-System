class Main {
	public static void main(String[] args) {
		// Prisoner p = new Prisoner("fh", 45, true, 56, "ggyg", 7878, 99887);
		// Prisoner p2 = new Prisoner("trtvgj", 23, true, 98, "ttrfd", 7878, 234);
		// Prisoner.writeFile(p);
		// Prisoner.writeFile(p2);
		// System.out.println(Prisoner.readFromFile());

		Police p = new Police("ass", 23, true, 34, "police", 3400, "rrugh", 12232, "Killing");
		Police p2 = new Police("abys", 45, true, 87, "warden", 54, "yryue", 2213, "murder");
		// Police.writeFile(p);
		// Police.writeFile(p2);
		System.out.println(Police.readFromFile());
		Police.delete("ass");
		System.out.println(Police.readFromFile());
		System.out.println(Police.searchByID(87));
	}
}