package com.jbohn.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryLookupModel implements Serializable {
	List<Country> lookups = new ArrayList<>();
}
