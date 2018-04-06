package edu.stanford.bmir.protege.web.server.renderer;

import edu.stanford.bmir.protege.web.server.shortform.DictionaryManager;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.util.ShortFormProvider;

import javax.annotation.Nonnull;
import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 5 Apr 2018
 */
public class ShortFormAdapter implements ShortFormProvider {

    @Nonnull
    private final DictionaryManager dictionaryManager;

    @Inject
    public ShortFormAdapter(@Nonnull DictionaryManager dictionaryManager) {
        this.dictionaryManager = checkNotNull(dictionaryManager);
    }

    @Nonnull
    @Override
    public String getShortForm(@Nonnull OWLEntity entity) {
        return dictionaryManager.getShortForms().stream().findFirst().orElse("");
    }

    @Override
    public void dispose() {

    }
}
