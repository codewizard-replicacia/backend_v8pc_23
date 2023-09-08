package test.model;


import lombok.Data;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


 
import test.model.Visit;
import test.model.Pet;
import test.model.PetOwner;
import test.model.VisitScheduler;
import test.model.Veterian;
import test.model.Appointment;
import test.model.VaccineScheduler;
import test.model.Image;
import test.converter.DurationConverter;
import test.converter.UUIDToByteConverter;
import test.converter.UUIDToStringConverter;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmFunction;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.Duration;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Lob;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmMediaStream;

@Entity(name = "Pet")
@Table(name = "\"Pet\"", schema =  "\"testv8\"")
@Data
                        
public class Pet {
	public Pet () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"Pet_id\"", nullable = true )
  private Integer pet_id;
	  
  @Column(name = "\"PetName\"", nullable = true )
  private String petName;
  
	  
  @Column(name = "\"PetCategory\"", nullable = true )
  private String petCategory;
  
	  
  @Column(name = "\"PetAge\"", nullable = true )
  private String petAge;
  
	  
  @Column(name = "\"PetGender\"", nullable = true )
  private String petGender;
  
	  
  @Column(name = "\"Breed\"", nullable = true )
  private String breed;
  
	  
  @Column(name = "\"PetDisplayImage\"", nullable = true )
  private String petDisplayImage;
  
  
  
  
   
	
@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"PetOwns\"",
            joinColumns = @JoinColumn( name="\"Pet_id\""),
            inverseJoinColumns = @JoinColumn( name="\"Pet_ownerId\""), schema = "\"testv8\"")
private List<PetOwner> owns = new ArrayList<>();


@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"PetVisits\"",
            joinColumns = @JoinColumn( name="\"Pet_id\""),
            inverseJoinColumns = @JoinColumn( name="\"Visit_id\""), schema = "\"testv8\"")
private List<Visit> visits = new ArrayList<>();


@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"PetPetImage\"",
            joinColumns = @JoinColumn( name="\"Pet_id\""),
            inverseJoinColumns = @JoinColumn( name="\"ImageId\""), schema = "\"testv8\"")
private List<Image> petImage = new ArrayList<>();
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "Pet [" 
  + "Pet_id= " + pet_id  + ", " 
  + "PetName= " + petName  + ", " 
  + "PetCategory= " + petCategory  + ", " 
  + "PetAge= " + petAge  + ", " 
  + "PetGender= " + petGender  + ", " 
  + "Breed= " + breed  + ", " 
  + "PetDisplayImage= " + petDisplayImage 
 + "]";
	}
	
}