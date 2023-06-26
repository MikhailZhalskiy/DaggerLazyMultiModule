package com.mw.example.daggerlazymultimodule.app.di

import android.app.Application
import com.mw.example.daggerlazymultimodule.navigation.di.NavigationApi
import com.mw.example.daggerlazymultimodule.navigation.di.NavigationComponentHolder
import com.mw.example.daggerlazymultimodule.navigation.di.NavigationDependencies
import com.mw.example.feature_detail_impl.di.DetailComponentHolder
import com.mw.example.feature_detail_impl.di.DetailDependencies
import com.mw.example.feature_list_impl.di.ListComponentHolder
import com.mw.example.feature_list_impl.di.ListDependencies
import com.mw.example.feature_pdf_api.PdfFeatureStarter
import com.mw.example.feature_pdf_impl.di.PdfComponentHolder
import com.mw.example.feature_pdf_impl.di.PdfDependencies
import com.mw.example.injector.BaseDependencies
import com.mw.example.injector.BaseDependencyHolder
import com.mw.example.injector.DependencyHolder0
import com.mw.example.injector.DependencyHolder1
import com.mw.example.injector.DependencyHolder2
import com.mw.example.injector.DependencyHolder3
import com.mw.example.injector_compose.binder.BinderBaseApi
import com.mw.example.injector_compose.api.InjectorComposeApi
import com.mw.example.injector_compose.di.InjectorComposeComponentHolder
import com.mw.example.injector_compose.di.InjectorComposeDependencies
import com.mw.example.repository_api.Repository
import com.mw.example.repository_api.di.RepositoryApi
import com.mw.example.repository_impl.di.RepositoryComponentHolder
import com.mw.example.repository_impl.di.RepositoryDependencies

object InitDi {

    internal fun init() {

        AppComponentHolder.dependencyProvider = {
            class AppComponentDependencyHolder(
                override val block: (BaseDependencyHolder<AppDependencies>, RepositoryApi, InjectorComposeApi, NavigationApi) -> AppDependencies
            ) : DependencyHolder3<RepositoryApi, InjectorComposeApi, NavigationApi, AppDependencies>(
                api1 = RepositoryComponentHolder.get(),
                api2 = InjectorComposeComponentHolder.get(),
                api3 = NavigationComponentHolder.get()
            )

            AppComponentDependencyHolder { dependencyHolder, repositoryApi, binderApiToEntryLifecycleApi, navigationApi ->
                object : AppDependencies {
                    override val repository: Repository
                        get() = repositoryApi.repository
                    override val activityLifecycleCallbacks: Application.ActivityLifecycleCallbacks
                        get() = binderApiToEntryLifecycleApi.activityLifecycleCallbacks
                    override val navigationApi: NavigationApi
                        get() = navigationApi
                    override val dependencyHolder: BaseDependencyHolder<out BaseDependencies>
                        get() = dependencyHolder
                }
            }.dependencies
        }

        InjectorComposeComponentHolder.dependencyProvider = {
            class FCHSComponentDependencyHolder(
                override val block: (BaseDependencyHolder<InjectorComposeDependencies>) -> InjectorComposeDependencies
            ) : DependencyHolder0<InjectorComposeDependencies>()

            FCHSComponentDependencyHolder { dependencyHolder ->
                object : InjectorComposeDependencies {
                    override val dependencyHolder: BaseDependencyHolder<out BaseDependencies>
                        get() = dependencyHolder
                }
            }.dependencies
        }

        RepositoryComponentHolder.dependencyProvider = {
            class RepositoryComponentDependencyHolder(
                override val block: (BaseDependencyHolder<RepositoryDependencies>) -> RepositoryDependencies
            ) : DependencyHolder0<RepositoryDependencies>()

            RepositoryComponentDependencyHolder { dependencyHolder ->
                object : RepositoryDependencies {
                    override val dependencyHolder: BaseDependencyHolder<out BaseDependencies>
                        get() = dependencyHolder
                }
            }.dependencies
        }

        NavigationComponentHolder.dependencyProvider = {
            class NavigationComponentDependencyHolder(
                override val block: (BaseDependencyHolder<NavigationDependencies>) -> NavigationDependencies
            ) : DependencyHolder0<NavigationDependencies>()

            NavigationComponentDependencyHolder { dependencyHolder ->
                object : NavigationDependencies {
                    override val dependencyHolder: BaseDependencyHolder<out BaseDependencies>
                        get() = dependencyHolder
                }
            }.dependencies
        }

        ListComponentHolder.dependencyProvider = {
            class ListComponentDependencyHolder(
                override val block: (BaseDependencyHolder<ListDependencies>, RepositoryApi, InjectorComposeApi) -> ListDependencies
            ) : DependencyHolder2<RepositoryApi, InjectorComposeApi, ListDependencies>(
                api1 = RepositoryComponentHolder.get(),
                api2 = InjectorComposeComponentHolder.get()
            )

            ListComponentDependencyHolder { dependencyHolder, repositoryApi, binderApiToEntryLifecycleApi ->
                object : ListDependencies {
                    override val repository: Repository
                        get() = repositoryApi.repository
                    override val binderBaseApi: BinderBaseApi
                        get() = binderApiToEntryLifecycleApi.binderBaseApi
                    override val dependencyHolder: BaseDependencyHolder<out BaseDependencies>
                        get() = dependencyHolder
                }
            }.dependencies
        }

        DetailComponentHolder.dependencyProvider = {
            class DetailComponentDependencyHolder(
                override val block: (BaseDependencyHolder<DetailDependencies>, RepositoryApi, NavigationApi, InjectorComposeApi) -> DetailDependencies
            ) : DependencyHolder3<RepositoryApi, NavigationApi, InjectorComposeApi, DetailDependencies>(
                api1 = RepositoryComponentHolder.get(),
                api2 = NavigationComponentHolder.get(),
                api3 = InjectorComposeComponentHolder.get()
            )

            DetailComponentDependencyHolder { dependencyHolder, repositoryApi, navigationApi, binderApiToEntryLifecycleApi ->
                object : DetailDependencies {
                    override val repository: Repository
                        get() = repositoryApi.repository
                    override val pdfFeatureStarter: PdfFeatureStarter
                        get() = navigationApi.pdfFeatureStarter
                    override val binderBaseApi: BinderBaseApi
                        get() = binderApiToEntryLifecycleApi.binderBaseApi
                    override val dependencyHolder: BaseDependencyHolder<out BaseDependencies>
                        get() = dependencyHolder
                }
            }.dependencies
        }

        PdfComponentHolder.dependencyProvider = {
            class PdfComponentDependencyHolder(
                override val block: (BaseDependencyHolder<PdfDependencies>, InjectorComposeApi) -> PdfDependencies
            ) : DependencyHolder1<InjectorComposeApi, PdfDependencies>(
                api1 = InjectorComposeComponentHolder.get()
            )

            PdfComponentDependencyHolder { dependencyHolder, injectorComposeApi ->
                object : PdfDependencies {
                    override val binderBaseApi: BinderBaseApi
                        get() = injectorComposeApi.binderBaseApi
                    override val dependencyHolder: BaseDependencyHolder<out BaseDependencies>
                        get() = dependencyHolder
                }
            }.dependencies
        }
    }
}