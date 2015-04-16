package org.reldb.rel.v1.storage.catalog;

import org.reldb.rel.exceptions.ExceptionSemantic;
import org.reldb.rel.v1.generator.SelectAttributes;
import org.reldb.rel.v1.storage.RelDatabase;
import org.reldb.rel.v1.storage.relvars.RelvarGlobal;
import org.reldb.rel.v1.storage.relvars.RelvarHeading;
import org.reldb.rel.v1.storage.relvars.RelvarMetadata;
import org.reldb.rel.v1.types.*;
import org.reldb.rel.v1.types.builtin.TypeBoolean;
import org.reldb.rel.v1.types.builtin.TypeCharacter;
import org.reldb.rel.v1.types.builtin.TypeInteger;

public class RelvarCatalogMetadata extends RelvarMetadata {
	public static final long serialVersionUID = 0;
	
	// This must parallel the ValueTuple created by getCatalogTupleIterator() in RelDatabase.
	static Heading getNewHeading() {
		Heading heading = new Heading();
		heading.add("Name", TypeCharacter.getInstance());
		heading.add("Definition", TypeCharacter.getInstance());
		heading.add("Owner", TypeCharacter.getInstance());
		heading.add("CreationSequence", TypeInteger.getInstance());
		heading.add("isVirtual", TypeBoolean.getInstance());
		return heading;
	}
	
	static RelvarHeading getNewKeyDefinition() {
		SelectAttributes attributes = new SelectAttributes();
		attributes.add("Name");
		RelvarHeading keyDefinition = new RelvarHeading(getNewHeading());
		keyDefinition.addKey(attributes);
		return keyDefinition;
	}
	
	public RelvarCatalogMetadata(RelDatabase database) {
		super(database, getNewKeyDefinition(), RelDatabase.systemOwner);
	}
	
	public RelvarGlobal getRelvar(String name, RelDatabase database) {
		return new RelvarCatalog(database);
	}	
	
	public void dropRelvar(RelDatabase database) {
		throw new ExceptionSemantic("RS0198: The " + Catalog.relvarCatalog + " relvar may not be dropped.");		
	}	
}
