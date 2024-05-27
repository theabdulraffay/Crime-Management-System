class Main {
	public static void main(String[] args) {
		Prisoner p = new Prisoner("fh", 45, true, 56, "ggyg", 7878, 99887);
		Prisoner p2 = new Prisoner("trtvgj", 23, true, 98, "ttrfd", 7878, 234);
		Prisoner.writeFile(p);
		Prisoner.writeFile(p2);
		System.out.println(Prisoner.readFromFile());
	}
}