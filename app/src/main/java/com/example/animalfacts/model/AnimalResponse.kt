package com.example.animalfacts.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class AnimalResponse(

	@field:SerializedName("characteristics")
	val characteristics: Characteristics? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("locations")
	val locations: List<String?>? = null,

	@field:SerializedName("taxonomy")
	val taxonomy: Taxonomy? = null
): Serializable

data class Taxonomy(

	@field:SerializedName("kingdom")
	val kingdom: String? = null,

	@field:SerializedName("phylum")
	val phylum: String? = null,

	@field:SerializedName("class")
	val `class`: String? = null,

	@field:SerializedName("order")
	val order: String? = null,

	@field:SerializedName("family")
	val family: String? = null,

	@field:SerializedName("genus")
	val genus: String? = null,

	@field:SerializedName("scientific_name")
	val scientificName: String? = null,
): Serializable

data class Characteristics(

	@field:SerializedName("most_distinctive_feature")
	val mostDistinctiveFeature: String? = null,

	@field:SerializedName("prey")
	val prey: String? = null,

	@field:SerializedName("habitat")
	val habitat: String? = null,

	@field:SerializedName("average_litter_size")
	val averageLitterSize: String? = null,

	@field:SerializedName("group_behavior")
	val groupBehavior: String? = null,

	@field:SerializedName("color")
	val color: String? = null,

	@field:SerializedName("lifespan")
	val lifespan: String? = null,

	@field:SerializedName("estimated_population_size")
	val estimatedPopulationSize: String? = null,

	@field:SerializedName("biggest_threat")
	val biggestThreat: String? = null,

	@field:SerializedName("weight")
	val weight: String? = null,

	@field:SerializedName("age_of_sexual_maturity")
	val ageOfSexualMaturity: String? = null,

	@field:SerializedName("skin_type")
	val skinType: String? = null,

	@field:SerializedName("lifestyle")
	val lifestyle: String? = null,

	@field:SerializedName("number_of_species")
	val numberOfSpecies: String? = null,

	@field:SerializedName("age_of_weaning")
	val ageOfWeaning: String? = null,

	@field:SerializedName("name_of_young")
	val nameOfYoung: String? = null,

	@field:SerializedName("gestation_period")
	val gestationPeriod: String? = null,

	@field:SerializedName("top_speed")
	val topSpeed: String? = null,

	@field:SerializedName("location")
	val location: String? = null,

	@field:SerializedName("diet")
	val diet: String? = null,

	@field:SerializedName("common_name")
	val commonName: String? = null,

	@field:SerializedName("slogan")
	val slogan: String? = null,

	@field:SerializedName("group")
	val group: String? = null,

	@field:SerializedName("height")
	val height: String? = null
): Serializable