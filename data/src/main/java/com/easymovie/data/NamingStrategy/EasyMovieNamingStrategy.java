package com.easymovie.data.NamingStrategy;

import org.hibernate.boot.model.naming.EntityNaming;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitBasicColumnNameSource;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.springframework.stereotype.Component;

/**
 * @author Manas Grover
 *
 */
@Component
public class EasyMovieNamingStrategy extends ImplicitNamingStrategyJpaCompliantImpl {

	private static final long serialVersionUID = -981307106671850539L;

	private final String prefix = "tbl_";
	private final String camelCased = "(.)(\\p{Upper})";
	private final String underscore_separated = "$1_$2";

	@Override
	protected String transformEntityName(EntityNaming entityNaming) {
		return prefix + transformName(super.transformEntityName(entityNaming));
	}

	private String transformName(String name) {
		return name.replaceAll(camelCased, underscore_separated).toLowerCase();
	}

	@Override
	public Identifier determineBasicColumnName(ImplicitBasicColumnNameSource source) {
		return toIdentifier(transformAttributePath(source.getAttributePath())
				.replaceAll(camelCased, underscore_separated).toLowerCase(), source.getBuildingContext());
	}
}