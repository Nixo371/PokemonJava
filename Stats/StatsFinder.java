package PokemonJava.Stats;

import java.io.File;
import java.util.Scanner;

import PokemonJava.Pokemon.Type;

import java.io.FileNotFoundException;

public class StatsFinder {
	
	public StatsFinder() {

	}

	public BaseStats get_base_stats(int id) {
		int hp, attack, defense, speed, special;
		
		// Open the CSV file
		File file = new File("PokemonJava/Data/pokemon.csv");
		try (Scanner scanner = new Scanner(file)) {
			// Read the data from the CSV file
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] data = line.split(",");
				// Extract the values from the CSV line
				int csvId = Integer.parseInt(data[0]);
				if (csvId == id) {
					hp = Integer.parseInt(data[2]);
					attack = Integer.parseInt(data[3]);
					defense = Integer.parseInt(data[4]);
					speed = Integer.parseInt(data[5]);
					special = Integer.parseInt(data[6]);
					// Create and return the BaseStats object
					BaseStats base_stats = new BaseStats(hp, attack, defense, speed, special);
					scanner.close();
					return (base_stats);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found");
		}
		return (null); // Return null if the ID is not found
	}

	public Type get_type1(int id) {
		String type1;

		// Open the CSV file
		File file = new File("PokemonJava/Data/pokemon.csv");
		try (Scanner scanner = new Scanner(file)) {
			// Read the data from the CSV file
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] data = line.split(",");
				// Extract the values from the CSV line
				int csvId = Integer.parseInt(data[0]);
				if (csvId == id) {
					type1 = data[7].toUpperCase();
					// Create and return the Type object
					Type type = Type.valueOf(type1);
					scanner.close();
					return (type);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found");
		}
		return (null); // Return null if the ID is not found
	}

	public Type get_type2(int id) {
		String type2;

		// Open the CSV file
		File file = new File("PokemonJava/Data/pokemon.csv");
		try (Scanner scanner = new Scanner(file)) {
			// Read the data from the CSV file
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] data = line.split(",");
				// Extract the values from the CSV line
				int csvId = Integer.parseInt(data[0]);
				if (csvId == id) {
					if (data[8].equals("None")) {
						scanner.close();
						return (null);
					}
					type2 = data[8].toUpperCase();
					// Create and return the Type object
					Type type = Type.valueOf(type2);
					scanner.close();
					return (type);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found");
		}
		return (null); // Return null if the ID is not found
	}

	public String get_name(int id) {
		String name;

		// Open the CSV file
		File file = new File("PokemonJava/Data/pokemon.csv");
		try (Scanner scanner = new Scanner(file)) {
			// Read the data from the CSV file
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] data = line.split(",");
				// Extract the values from the CSV line
				int csvId = Integer.parseInt(data[0]);
				if (csvId == id) {
					name = data[1];
					// Create and return the Type object
					scanner.close();
					return (name);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found");
		}
		return ("MissingNo"); // Got em
	}
	
}
